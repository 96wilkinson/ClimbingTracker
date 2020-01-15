package rest;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bae.Application;
import com.bae.persistence.domain.Climber;
import com.bae.persistence.domain.ClimbingAttempts;
import com.bae.persistence.repository.ClimberRepository;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ClimberControllerIntegrationTest {
    @Autowired
    private MockMvc mock;

    @Autowired
    private ClimberRepository testClimberRepository;

    @Autowired
    private ClimbingAttemptRepository testAttemptRepository;

    private ObjectMapper mapper = new ObjectMapper();

    private long id;

    private Climber testClimber;

    private Climber testClimberWithID;

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
        this.testClimberRepository.deleteAll();
        this.testClimbingAttemptsSet.add(attemptToSaveToRepo);
        this.testAttemptRepository.saveAndFlush(this.attemptToSaveToRepo);

        this.testClimber = new Climber("96wilkinson", "Tony", "Wilkinson", testClimbingAttemptsSet);
        this.testClimberWithID = this.testClimberRepository.save(this.testClimber);
        this.id = this.testClimberWithID.getId();
    }
    @Test
    public void testCreateClimber() throws Exception {
        String result = this.mock
                .perform(request(HttpMethod.POST, "/climberapp/createClimber").contentType(MediaType.APPLICATION_JSON)
                        .content(this.mapper.writeValueAsString(testClimber)).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        assertEquals(this.mapper.writeValueAsString(testClimberWithID), result);
    }
    @Test
    public void testGetAllClimbers() throws Exception {
        List<Climber> climberList = new ArrayList<>();
        climberList.add(this.testClimberWithID);

        String content = this.mock.perform(request(HttpMethod.GET, "/climberapp/getAll").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(this.mapper.writeValueAsString(climberList), content);
    }
    @Test
    public void testUpdateClimber() throws Exception {
        Climber newClimber = new Climber("Bear", "Bear", "Grylls", testClimbingAttemptsSet);
        Climber updatedClimber = new Climber(newClimber.getUsername(), newClimber.getFirstname(), newClimber.getSurname(), newClimber.getClimbingAttempts());
        updatedClimber.setId(this.id);

        String result = this.mock
                .perform(request(HttpMethod.PUT, "/climberapp/updateClimber/" + this.id).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newClimber)))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(this.mapper.writeValueAsString(updatedClimber), result);

    }
    @Test
    public void testDeleteClimber() throws Exception {
        this.mock.perform(request(HttpMethod.DELETE, "/climberapp/DeleteClimber/" + this.id)).andExpect(status().isOk());
    }
}
