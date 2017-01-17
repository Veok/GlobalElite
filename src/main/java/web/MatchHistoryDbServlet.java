package web;

import dao.RepositoryCatalog;
import dao.repositories.IRepositoryCatalog;
import domain.model.MatchHistory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author L on 16.01.2017.
 */
@WebServlet("/MatchHistoryDbServlet")
@Transactional
@Component
public class MatchHistoryDbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String url = "jdbc:hsqldb:hsql://localhost/workdb";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            IRepositoryCatalog catalog = new RepositoryCatalog(url);
            HttpSession session = req.getSession();
            MatchHistory matchHistory = (MatchHistory) session.getAttribute("matchHistory");
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session session1 = sessionFactory.openSession();
            session1.beginTransaction();
            session1.save(matchHistory);
            session1.getTransaction().commit();
            session1.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
