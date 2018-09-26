package sapient.assignment.cricapi;

import org.springframework.context.annotation.Bean;
import sapient.assignment.cricapi.entity.MatchSummary;
import sapient.assignment.cricapi.entity.Score;
import sapient.assignment.cricapi.entity.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MatchAPIService {
    private List<MatchSummary> matchList = new ArrayList<>();
    private List<MatchSummary> matchListWithScores = new ArrayList<>();

    public MatchAPIService() {
        for (int i = 1; i <= 10; i++) {
            MatchSummary match = new MatchSummary();
            match.setMatchId("" + (i * i));
            match.setMatchOver(true);
            match.setTeam1(new Team(i + "", "Random Team #" + i));
            match.setTeam2(new Team((i * 2) + "", "Random Team #" + (i * 2)));
            matchList.add(match);

            MatchSummary matchWithScore = new MatchSummary();
            matchWithScore.setMatchId("" + (i * i));
            matchWithScore.setMatchOver(true);
            matchWithScore.setTeam1(new Team(i + "", "Random Team #" + i, new Score(new Random().nextInt(200), new Random().nextInt(9))));
            matchWithScore.setTeam2(new Team((i * 2) + "", "Random Team #" + (i * 2), new Score(new Random().nextInt(200), new Random().nextInt(10))));
            matchListWithScores.add(matchWithScore);
        }
    }

    public List<MatchSummary> getMatchList() {
        List<MatchSummary> copy = new ArrayList<>();
        copy.addAll(matchList);
        return copy;
    }

    public MatchSummary getMatchSummary(String matchId) {
        for (int i = 0; i < matchListWithScores.size(); i++) {
            if (matchId.equals(matchListWithScores.get(i).getMatchId())) {
                return matchListWithScores.get(i);
            }
        }
        return null;
    }
}
