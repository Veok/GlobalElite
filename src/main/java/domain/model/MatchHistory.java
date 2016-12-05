package domain.model;

import java.util.Date;

/**
 * @author L on 10.11.2016.
 */
public class MatchHistory implements IHaveId {

    private int id;
    private Team team1;
    private Team team2;
    private Date timeOfMatch;
    private GameMap gameMap;
    private int scoreOfTeam1;
    private int scoreOfTeam2;
    private MatchScoreBoard matchScoreBoard;

    public MatchHistory() {

    }


    public void score() {

        if (scoreOfTeam1 > scoreOfTeam2) {
            team1.getTeamStatistics().setWins(team1.getTeamStatistics().getWins() + 1);
            team2.getTeamStatistics().setLooses(team2.getTeamStatistics().getLooses() + 1);
        } else if (scoreOfTeam1 < scoreOfTeam2) {
            team2.getTeamStatistics().setWins(team2.getTeamStatistics().getWins() + 1);
            team1.getTeamStatistics().setLooses(team1.getTeamStatistics().getLooses() + 1);
        } else {
            team1.getTeamStatistics().setDraws(team1.getTeamStatistics().getDraws() + 1);
            team2.getTeamStatistics().setDraws(team2.getTeamStatistics().getDraws() + 1);
        }
    }


    public MatchScoreBoard getMatchScoreBoard() {
        return matchScoreBoard;
    }

    public void setMatchScoreBoard(MatchScoreBoard matchScoreBoard) {
        this.matchScoreBoard = matchScoreBoard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Date getTimeOfMatch() {
        return timeOfMatch;
    }

    public void setTimeOfMatch(Date timeOfMatch) {
        this.timeOfMatch = timeOfMatch;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public int getScoreOfTeam1() {
        return scoreOfTeam1;
    }

    public void setScoreOfTeam1(int scoreOfTeam1) {
        this.scoreOfTeam1 = scoreOfTeam1;
    }

    public int getScoreOfTeam2() {
        return scoreOfTeam2;
    }

    public void setScoreOfTeam2(int scoreOfTeam2) {
        this.scoreOfTeam2 = scoreOfTeam2;
    }


}
