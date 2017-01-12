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
 * @author L on 11.01.2017.
 */

@WebServlet("/PlayerServlet")
public class PlayerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "jdbc:hsqldb:hsql://localhost/workdb";
        try {
            IRepositoryCatalog catalog = new RepositoryCatalog(url);

            if (!catalog.players().withNick(req.getParameter("nick")).isEmpty()) {
                HttpSession session = req.getSession();
                session.setAttribute(SessionKey.player, catalog.players().getName(req.getParameter("nick")));
                if (catalog.players().getName(req.getParameter("nick")).getTeam() != null) {
                    resp.sendRedirect("profile.jsp");
                } else {
                    resp.sendRedirect("newProfile.jsp");
                }
            } else {
                resp.getWriter().println("Brak danego gracza");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
