package sapient.assignment.cricapi.entity;

public class Score {
    int score, wickets;

    public Score(int score, int wickets) {
        this.score = score;
        this.wickets = wickets;
    }

    public int getWickets() {
        return wickets;
    }

    public int getScore() {
        return score;
    }

}
