package domain.model;

/**
 * Created by L on 10.11.2016.
 */
public class HistoryOfMatch {

    private Team team1;
    private Team team2;
    private String timeOfMatch;
    private Maps map;
    private int scoreOfTeam1;
    private int scoreOfTeam2;
    private ScoreBoard scoreBoard;

    public HistoryOfMatch() {
    }

    public void score() {

        if (scoreOfTeam1 > scoreOfTeam2) {
            team1.getTeamStats().setWins(team1.getTeamStats().getWins() + 1);
            team2.getTeamStats().setLooses(team2.getTeamStats().getLooses() + 1);
        } else if (scoreOfTeam1 < scoreOfTeam2) {
            team2.getTeamStats().setWins(team2.getTeamStats().getWins() + 1);
            team1.getTeamStats().setLooses(team1.getTeamStats().getLooses() + 1);
        } else {
            team1.getTeamStats().setDraws(team1.getTeamStats().getDraws() + 1);
            team2.getTeamStats().setDraws(team2.getTeamStats().getDraws() + 1);
        }
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
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

    public String getTimeOfMatch() {
        return this.timeOfMatch;
    }

    public void setTimeOfMatch(String timeOfMatch) {
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
