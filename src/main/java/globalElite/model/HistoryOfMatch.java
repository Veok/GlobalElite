package globalElite.model;

import java.util.Date;

/**
 * Created by L on 10.11.2016.
 */
public class HistoryOfMatch {

    private Team team1Name;
    private Team team2Name;
    private Date timeOfMatch;
    private Maps map;
    private int scoreOfTeam1;
    private int scoreOfTeam2;
    private ScoreBoard scoreBoard;

    public HistoryOfMatch() {
    }

    public void score() {

        if (scoreOfTeam1 > scoreOfTeam2) {
            team1Name.getTeamStats().setWins(team1Name.getTeamStats().getWins() + 1);
            team2Name.getTeamStats().setLooses(team2Name.getTeamStats().getLooses() + 1);
        } else if (scoreOfTeam1 < scoreOfTeam2) {
            team2Name.getTeamStats().setWins(team2Name.getTeamStats().getWins() + 1);
            team1Name.getTeamStats().setLooses(team1Name.getTeamStats().getLooses() + 1);
        } else {
            team1Name.getTeamStats().setDraws(team1Name.getTeamStats().getDraws() + 1);
            team2Name.getTeamStats().setDraws(team2Name.getTeamStats().getDraws() + 1);
        }
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }


    public Team getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(Team team1Name) {
        this.team1Name = team1Name;
    }

    public Team getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(Team team2Name) {
        this.team2Name = team2Name;
    }

    public Date getTimeOfMatch() {
        return timeOfMatch;
    }

    public void setTimeOfMatch(Date timeOfMatch) {
        this.timeOfMatch = timeOfMatch;
    }

    public Maps getMap() {
        return map;
    }

    public void setMap(Maps map) {
        this.map = map;
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
