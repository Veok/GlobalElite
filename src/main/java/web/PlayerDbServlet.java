package web;

import dao.RepositoryCatalog;
import dao.repositories.IRepositoryCatalog;
import domain.model.Player;
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
 * @author L on 31.12.2016.
 */
@WebServlet("/PlayerDbServlet")

public class PlayerDbServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public PlayerDbServlet() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "jdbc:hsqldb:hsql://localhost/workdb";
        try {

            IRepositoryCatalog catalog = new RepositoryCatalog(url);
            HttpSession session = req.getSession();
            Player player = (Player) session.getAttribute("player");
            Team team = new Team();
            TeamStatistics teamStatistics = new TeamStatistics();
            catalog.teamsStats().add(teamStatistics);
            catalog.teams().add(team);
            catalog.players().add(player);
            catalog.saveAndClose();
            resp.sendRedirect("signIn.html");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
