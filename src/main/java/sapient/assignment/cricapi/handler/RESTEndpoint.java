package sapient.assignment.cricapi.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sapient.assignment.cricapi.MatchAPIService;
import sapient.assignment.cricapi.entity.MatchSummary;
import sapient.assignment.cricapi.entity.Score;
import sapient.assignment.cricapi.entity.Team;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RESTEndpoint {

    private MatchAPIService service = new MatchAPIService();

    @GetMapping(value = "/match/{matchId}")
    public ResponseEntity getMatchDetails(@PathVariable(value = "matchId") String matchId) {
        MatchSummary match = service.getMatchSummary(matchId);
        return ResponseEntity.ok(match);
    }

    @GetMapping(value = "/matches")
    public ResponseEntity getMatches() {
        List<MatchSummary> matches = service.getMatchList();

        return ResponseEntity.ok(matches);
    }
}
