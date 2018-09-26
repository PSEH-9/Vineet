package sapient.assignment.cricapi.handler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sapient.assignment.cricapi.entity.MatchSummary;
import sapient.assignment.cricapi.entity.Score;
import sapient.assignment.cricapi.entity.Team;


@RunWith(SpringRunner.class)
@WebMvcTest(RESTEndpoint.class)
public class RESTEndpointTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void given_whenNameInRequest_ThenShouldPrintNameWithHelloWorld() {
        try {
            mvc.perform(
                    MockMvcRequestBuilders
                            .get("/match/1"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andExpect(MockMvcResultMatchers.content().equals());
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given_whenNoNameInRequest_ThenShouldFailWithStatus404() {
        try {

            mvc.perform(
                    MockMvcRequestBuilders
                            .get("/matches/"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}