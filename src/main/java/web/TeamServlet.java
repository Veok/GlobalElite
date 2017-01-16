package web;

import dao.RepositoryCatalog;
import dao.repositories.IRepositoryCatalog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author L on 09.01.2017.
 */
@WebServlet("/TeamServlet")
public class TeamServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "jdbc:hsqldb:hsql://localhost/workdb";
        try {
            IRepositoryCatalog catalog = new RepositoryCatalog(url);

            if (!catalog.teams().withName(req.getParameter("name")).isEmpty()) {
                HttpSession session = req.getSession();
                session.setAttribute(SessionKey.teamStats, catalog.teamsStats()
                        .get(catalog.teams().getName(req.getParameter("name"))
                                .getId()));
                session.setAttribute(SessionKey.team, catalog.teams().getName(req.getParameter("name")));
                resp.sendRedirect("team.jsp");
            } else {
                resp.getWriter().println("Brak danej drużyny w bazie");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
