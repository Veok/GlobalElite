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
        TeamService teamService = new TeamService();
        MatchHistory matchHistory = new MatchHistory();

        Team team1 = teamService.getTeamByName(req.getParameter("name1"));
        Team team2 = teamService.getTeamByName(req.getParameter("name2"));
        matchHistory.setScoreOfTeam1(Integer.parseInt(req.getParameter("score1")));
        matchHistory.setScoreOfTeam2(Integer.parseInt(req.getParameter("score2")));
        matchHistory.setTimeOfMatch(req.getParameter("time"));

        if (team1 == null || team2 == null) {
            resp.getWriter().write("Brak druzyny w bazie");
        } else if (!org.apache.commons.lang3.StringUtils.isNumeric(matchHistory.getTimeOfMatch())) {
            resp.getWriter().write("Podales zly czas trwania meczu");
        } else if (matchHistory.getScoreOfTeam1() < 0 || matchHistory.getScoreOfTeam2() < 0) {
            resp.getWriter().write("Wyniki drużyn nie mogą być ujemne");
        } else {

            matchHistory.setTeam1(team1);
            matchHistory.setTeam2(team2);

            matchHistory.setGameMap(gameMap);
            HttpSession session = req.getSession();
            session.setAttribute(SessionKey.matchHistory, matchHistory);
            session.setAttribute(SessionKey.gameMap, gameMap);
            resp.sendRedirect("/addMatch.jsp");
        }


    }
}
