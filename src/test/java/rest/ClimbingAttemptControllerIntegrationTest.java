package rest;


import com.bae.Application;
import com.bae.persistence.domain.ClimbingAttempts;
import com.bae.persistence.repository.ClimbingAttemptRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ClimbingAttemptControllerIntegrationTest {
    @Autowired
    private MockMvc mock;

    @Autowired
    private ClimbingAttemptRepository testAttemptRepository;

    private ObjectMapper mapper = new ObjectMapper();

    private Long id;

    private ClimbingAttempts testClimbingAttempt = new ClimbingAttempts(18, 12, 1996, 3, 5);

    private ClimbingAttempts testClimbingAttemptsWithID;

    private final int DAY = 18;
    private final int MONTH = 12;
    private final int YEAR = 1996;
    private final int DIFFICULTY = 3;
    private final int TIME_SPENT = 5;

    private final ClimbingAttempts attemptToSaveToRepo = new ClimbingAttempts(DAY
            , MONTH, YEAR, DIFFICULTY, TIME_SPENT);

    private Set<ClimbingAttempts> testClimbingAttemptsSet = new HashSet<>();

    @Before
    public void init() {
        this.testAttemptRepository.deleteAll();

        this.testClimbingAttemptsSet.add(attemptToSaveToRepo);

        this.testClimbingAttemptsWithID = this.testAttemptRepository.saveAndFlush(this.attemptToSaveToRepo);

        this.id = this.testClimbingAttemptsWithID.getId();
    }

    @Test
    public void testCreateClimbingAttempt() throws Exception {
        String result = this.mock
                .perform(request(HttpMethod.POST, "/climberapp/createClimbingAttempt/" + this.id).contentType(MediaType.APPLICATION_JSON)
                        .content(this.mapper.writeValueAsString(attemptToSaveToRepo)).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        assertEquals(this.mapper.writeValueAsString(testClimbingAttemptsWithID), result);
    }

    @Test
    public void testGetAllClimbingAttempts() throws Exception {
        List<ClimbingAttempts> climberList = new ArrayList<>();
        climberList.add(this.testClimbingAttemptsWithID);

        String content = this.mock.perform(request(HttpMethod.GET, "/climberapp/getAllClimbingAttempts").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(this.mapper.writeValueAsString(climberList), content);
    }

    @Test
    public void testUpdateClimbingAttempt() throws Exception {
        ClimbingAttempts newClimbingAttempts = new ClimbingAttempts(22, 11, 1997, 3, 5);
        ClimbingAttempts updatedClimbingAttempts = new ClimbingAttempts(newClimbingAttempts.getDay(), newClimbingAttempts.getMonth()
                , newClimbingAttempts.getYear(), newClimbingAttempts.getDifficulty(), newClimbingAttempts.getTimeSpent());
        updatedClimbingAttempts.setId(this.id);

        String result = this.mock
                .perform(request(HttpMethod.PUT, "/climberapp/updateClimbingAttempt/" + this.id).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newClimbingAttempts)))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(this.mapper.writeValueAsString(updatedClimbingAttempts), result);

    }

    @Test
    public void testDeleteClimbingAttempt() throws Exception {
        this.mock.perform(request(HttpMethod.DELETE, "/climberapp/DeleteClimbingAttempt/" + this.id)).andExpect(status().isOk());
    }
}
