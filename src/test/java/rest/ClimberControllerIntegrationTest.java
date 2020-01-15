/*
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
    private ClimberRepository repo;

    private ObjectMapper mapper = new ObjectMapper();

    private long id;

    private Climber testClimber;

    private Climber testClimberWithID;

    Set<ClimbingAttempts> TEST_Attempt = new HashSet<ClimbingAttempts>();

    @Before
    public void init() {
        this.repo.deleteAll();

        this.testClimber = new Climber("96wilkinson", "Tony", "Wilkinson",TEST_Attempt);
        this.testClimberWithID = this.repo.save(this.testClimber);
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
        Climber newClimber = new Climber("Bear", "Bear", "Grylls",TEST_Attempt);
        Climber updatedClimber = new Climber(newClimber.getUsername(), newClimber.getFirstname(), newClimber.getSurname(),newClimber.getClimbingAttempts());
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
*/
