package web;

import domain.model.GameMap;
import domain.model.MatchHistory;
import hdao.HibernateUtil;
import hdao.services.RepositoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;

/**
 * @author L on 16.01.2017.
 */
@WebServlet("/MatchHistoryDbServlet")
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class MatchHistoryDbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RepositoryService repositoryService = new RepositoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        MatchHistory matchHistory = (MatchHistory) session.getAttribute("matchHistory");
        GameMap gameMap = (GameMap) session.getAttribute("gameMap");
        matchHistory.score();


        repositoryService.gameMaps().add(gameMap);
        repositoryService.history().add(matchHistory);
        repositoryService.teamStats().update(matchHistory.getTeam1().getTeamStatistics());
        repositoryService.teamStats().update(matchHistory.getTeam2().getTeamStatistics());

        resp.sendRedirect("/matchHistory.jsp");
    }

}

