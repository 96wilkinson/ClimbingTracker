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
import org.springframework.test.context.ContextConfiguration;
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
    private ClimbingAttemptRepository repo;

    private ObjectMapper mapper = new ObjectMapper();

    private Long id;

    private List<ClimbingAttempts> climbingAttemptList;

    private ClimbingAttempts testClimbingAttempt;

    Set<ClimbingAttempts> TEST_Attempt = new HashSet<ClimbingAttempts>();

    private ClimbingAttempts testClimbingAttemptsWithID;

    @Before
    public void init() {
        this.climbingAttemptList = new ArrayList<>();
        this.testClimbingAttempt = new ClimbingAttempts(1,18,12,1996,3);
        this.TEST_Attempt.add(testClimbingAttempt);
        this.repo.deleteAll();
        this.testClimbingAttemptsWithID = this.repo.save(this.testClimbingAttempt);
        this.id = this.testClimbingAttemptsWithID.getId();
    }
    @Test
    public void testCreateClimbingAttempt() throws Exception {
        String result = this.mock
                .perform(request(HttpMethod.POST, "/climberapp/createClimbingAttempt").contentType(MediaType.APPLICATION_JSON)
                        .content(this.mapper.writeValueAsString(testClimbingAttempt)).accept(MediaType.APPLICATION_JSON))
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
        ClimbingAttempts newClimbingAttempts = new ClimbingAttempts(22,11,1997,3,5);
        ClimbingAttempts updatedClimbingAttempts = new ClimbingAttempts(newClimbingAttempts.getDay(),newClimbingAttempts.getMonth()
                ,newClimbingAttempts.getYear(),newClimbingAttempts.getDifficulty(),newClimbingAttempts.getTimeSpent());
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
