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
    private int mapId;
    private int scoreOfTeam1;
    private int scoreOfTeam2;
    private MatchScoreBoard matchScoreBoard;

    public MatchHistory() {
    }

    public void score() {

        if (scoreOfTeam1 > scoreOfTeam2) {
            team1.getGeneralTeamStats().setWins(team1.getGeneralTeamStats().getWins() + 1);
            team2.getGeneralTeamStats().setLooses(team2.getGeneralTeamStats().getLooses() + 1);
        } else if (scoreOfTeam1 < scoreOfTeam2) {
            team2.getGeneralTeamStats().setWins(team2.getGeneralTeamStats().getWins() + 1);
            team1.getGeneralTeamStats().setLooses(team1.getGeneralTeamStats().getLooses() + 1);
        } else {
            team1.getGeneralTeamStats().setDraws(team1.getGeneralTeamStats().getDraws() + 1);
            team2.getGeneralTeamStats().setDraws(team2.getGeneralTeamStats().getDraws() + 1);
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

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
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
