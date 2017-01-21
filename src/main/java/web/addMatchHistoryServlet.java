package web;

import domain.model.GameMap;
import domain.model.MatchHistory;
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
 * @author L on 31.12.2016.
 */
@WebServlet("/addMatchHistoryServlet")
public class addMatchHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GameMap gameMap = new GameMap();
        gameMap.setNameOfMap(req.getParameter("gameMap"));

        MatchHistory matchHistory = new MatchHistory();
        Team team1 = TeamService.getTeamByName(req.getParameter("name1"));
        Team team2 = TeamService.getTeamByName(req.getParameter("name2"));
        matchHistory.setTeam1(team1);
        matchHistory.setTeam2(team2);
        matchHistory.setScoreOfTeam1(Integer.parseInt(req.getParameter("score1")));
        matchHistory.setScoreOfTeam2(Integer.parseInt(req.getParameter("score2")));
        matchHistory.setTimeOfMatch(req.getParameter("time"));
        matchHistory.setGameMap(gameMap);
        matchHistory.score();
        HttpSession session = req.getSession();
        session.setAttribute(SessionKey.matchHistory, matchHistory);
        session.setAttribute(SessionKey.gameMap, gameMap);
        resp.sendRedirect("/addMatch.jsp");


    }
}
