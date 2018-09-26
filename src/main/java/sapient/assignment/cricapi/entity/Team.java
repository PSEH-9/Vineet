package sapient.assignment.cricapi.entity;

public class Team {

    private String teamId, name;
    private Score score;


    public Team(String id, String name) {
        setTeamId(id);
        setName(name);
    }

    public Team(String id, String name, Score score) {
        setTeamId(id);
        setName(name);
        setScore(score);
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

}
