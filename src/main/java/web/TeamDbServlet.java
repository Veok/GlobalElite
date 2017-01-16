package web;

import dao.RepositoryCatalog;
import dao.repositories.IRepositoryCatalog;
import domain.model.Team;
import domain.model.TeamStatistics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author L on 13.01.2017.
 */
@WebServlet("/TeamDbServlet")

public class TeamDbServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "jdbc:hsqldb:hsql://localhost/workdb";


        try {
            IRepositoryCatalog catalog = new RepositoryCatalog(url);
            HttpSession session = req.getSession();
            Team team = (Team) session.getAttribute("team");
            TeamStatistics teamStatistics = (TeamStatistics) session.getAttribute("teamStats");
            catalog.teamsStats().add(teamStatistics);
            catalog.teams().add(team);
            catalog.save();
            catalog.teams().getLastIdForForeignKey();
            catalog.save();
            catalog.close();
            resp.sendRedirect("signIn.html");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
