package sapient.assignment.cricapi.entity;

public class MatchSummary {
    private String matchId;
    private boolean matchOver;
    private Team team1, team2;

    public boolean isMatchOver() {
        return matchOver;
    }

    public void setMatchOver(boolean matchOver) {
        this.matchOver = matchOver;
    }


    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
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

    public String getWinner() {
        if (isMatchOver()) {
            if (getTeam1().getScore().score > getTeam2().getScore().score) {
                return getTeam1().getTeamId();
            } else if (getTeam1().getScore().score < getTeam2().getScore().score) {
                return getTeam2().getTeamId();
            } else {
                return "draw";
            }
        }
        return "match on going";
    }

}
