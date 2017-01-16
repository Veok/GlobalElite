package web;

import domain.model.Player;
import domain.model.Team;

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
@WebServlet("/addPlayerServlet")
public class addPlayerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Player player = new Player();
        player.setNick(req.getParameter("nick"));
        player.setSteamId(req.getParameter("steam_id"));
        player.setCountry(req.getParameter("country"));
        player.setDateOfBirth(req.getParameter("dob"));
        player.setTeam(new Team());


        HttpSession session = req.getSession();
        session.setAttribute(SessionKey.player, player);

        resp.sendRedirect("/signUp.jsp");

    }
}
