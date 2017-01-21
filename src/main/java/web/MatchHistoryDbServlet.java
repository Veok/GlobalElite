package web;

import domain.model.GameMap;
import domain.model.MatchHistory;
import hdao.TeamService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
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
@Component
public class MatchHistoryDbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        MatchHistory matchHistory = (MatchHistory) session.getAttribute("matchHistory");
        GameMap gameMap = (GameMap) session.getAttribute("gameMap");
        matchHistory.setGameMap(gameMap);
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        if (TeamService.getTeamByName(matchHistory.getTeam1().getName()) == null
                || TeamService.getTeamByName(matchHistory.getTeam2().getName()) == null) {
            resp.getWriter().write("Brak danych drużyn w bazie. Wprowadź prawidłowe nazwy drużyn.");
        }
         else if(matchHistory.getTimeOfMatch()==null || matchHistory.getGameMap().getNameOfMap()==null){
            resp.getWriter().write("Pole nie może być puste");
        }
         else if(matchHistory.getScoreOfTeam1()<0 || matchHistory.getScoreOfTeam2()<0){
            resp.getWriter().write("Wyniki drużyn nie mogą być ujemne");
        }
        else {
            Session session1 = sessionFactory.openSession();
            session1.beginTransaction();
            session1.save(matchHistory);
            session1.save(gameMap);
            session1.update(matchHistory.getTeam1().getTeamStatistics());
            session1.update(matchHistory.getTeam2().getTeamStatistics());
            session1.getTransaction().commit();
            session1.close();
        }

    }


}
