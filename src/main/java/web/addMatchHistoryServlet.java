package web;

import dao.RepositoryCatalog;
import dao.repositories.IRepositoryCatalog;
import domain.model.GameMap;
import domain.model.MatchHistory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author L on 31.12.2016.
 */
@WebServlet("/addMatchHistoryServlet")
public class addMatchHistoryServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    String url = "jdbc:hsqldb:hsql://localhost/workdb";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            IRepositoryCatalog catalog = new RepositoryCatalog(url);
            MatchHistory matchHistory = new MatchHistory();
            matchHistory.setTeam1(catalog.teams().getName(req.getParameter("name1")));
            matchHistory.setTeam2(catalog.teams().getName(req.getParameter("name2")));
            matchHistory.setScoreOfTeam1(Integer.parseInt(req.getParameter("score1")));
            matchHistory.setScoreOfTeam2(Integer.parseInt(req.getParameter("score2")));
            matchHistory.setTimeOfMatch(req.getParameter("map"));
            matchHistory.setGameMap(new GameMap());

            HttpSession session = req.getSession();
            session.setAttribute(SessionKey.matchHistory, matchHistory);
            resp.sendRedirect("/addMatch.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
