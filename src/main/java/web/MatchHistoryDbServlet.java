package web;

import domain.model.GameMap;
import domain.model.MatchHistory;
import hdao.HibernateUtil;
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
@Transactional
public class MatchHistoryDbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        MatchHistory matchHistory = (MatchHistory) session.getAttribute("matchHistory");
        GameMap gameMap = (GameMap) session.getAttribute("gameMap");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        matchHistory.score();

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        session1.save(matchHistory);
        session1.save(gameMap);
        session1.update(matchHistory.getTeam1().getTeamStatistics());
        session1.update(matchHistory.getTeam2().getTeamStatistics());
        session1.getTransaction().commit();
        session1.close();
        resp.sendRedirect("/matchHistory.jsp");
    }

}

