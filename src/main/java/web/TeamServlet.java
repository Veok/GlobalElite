package web;

import domain.model.Team;
import hdao.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author L on 09.01.2017.
 */
@WebServlet("/TeamServlet")
public class TeamServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        TeamService teamService = new TeamService();
        if (teamService.getTeamByName(name)!= null) {
            HttpSession session = req.getSession();
            session.setAttribute(SessionKey.login, teamService.getTeamByName(name));
            resp.sendRedirect("/team.jsp");
        } else {
            resp.getWriter().println("Brak danej drużyny w bazie");
        }
    }


}
