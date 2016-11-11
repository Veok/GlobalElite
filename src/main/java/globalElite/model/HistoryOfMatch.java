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
    private ScoreOfPlayer scoreOfPlayer;

    public HistoryOfMatch() {
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

    public ScoreOfPlayer getScoreOfPlayer() {
        return scoreOfPlayer;
    }

    public void setScoreOfPlayer(ScoreOfPlayer scoreOfPlayer) {
        this.scoreOfPlayer = scoreOfPlayer;
    }
}
