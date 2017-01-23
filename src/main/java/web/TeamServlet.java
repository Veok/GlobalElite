package web;

import hdao.services.RepositoryService;
import hdao.services.TeamService;

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
        RepositoryService repositoryService = new RepositoryService();
        if (repositoryService.teams().withName(name)!= null) {
            HttpSession session = req.getSession();
            session.setAttribute(SessionKey.login, repositoryService.teams().withName(name));
            resp.sendRedirect("/team.jsp");
        } else {
            resp.getWriter().println("Brak danej drużyny w bazie");
        }
    }


}
