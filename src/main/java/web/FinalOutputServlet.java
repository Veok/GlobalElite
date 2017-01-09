package web;

import domain.model.Player;
import domain.model.Team;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author L on 31.12.2016.
 */
public class FinalOutputServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Player player = (Player) session.getAttribute(SessionKey.player);
        Team team = (Team) session.getAttribute(SessionKey.team);


        resp.setContentType("text/html");


}}
