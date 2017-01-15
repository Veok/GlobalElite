package web;

import domain.model.Player;
import domain.model.Team;
import domain.model.TeamStatistics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;

/**
 * @author L on 31.12.2016.
 */
@WebServlet("/addTeamServlet")
public class addTeamServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Team team = new Team();
        team.setName(req.getParameter("name"));
        team.setCountry(req.getParameter("country"));
        TeamStatistics teamStatistics = new TeamStatistics();
        teamStatistics.setWins(0);
        teamStatistics.setLooses(0);
        teamStatistics.setDraws(0);
        team.setTeamStatistics(teamStatistics);


        HttpSession session = req.getSession();
        session.setAttribute(SessionKey.teamStats, teamStatistics);
        session.setAttribute(SessionKey.team, team);

        resp.sendRedirect("/createTeam.jsp");

    }
}
