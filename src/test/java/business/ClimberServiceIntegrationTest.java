package business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.*;

import com.bae.persistence.domain.ClimbingAttempts;
import com.bae.persistence.repository.ClimbingAttemptRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.Application;
import com.bae.bussiness.ClimberService;
import com.bae.persistence.repository.ClimberRepository;
import com.bae.persistence.domain.Climber;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
public class ClimberServiceIntegrationTest {

    @Autowired
    private ClimberService service;

    @Autowired
    private ClimberRepository climberRepository;

    @Autowired
	private ClimbingAttemptRepository attemptRepository;

    private Climber ClimberToSaveToRepo;

    private Climber climberToCheckTestAgainst;

    private List<Climber> climberList = new ArrayList<>();

    private ClimbingAttempts attemptToSaveToRepo;

	private ClimbingAttempts testClimbingAttemptsWithID;

    private Set<ClimbingAttempts> testClimbingAttemptSet = new HashSet<>();

    @Before
    public void init() {
        this.attemptToSaveToRepo = new ClimbingAttempts(1, 18, 12, 1996, 3);
        this.testClimbingAttemptSet.add(attemptToSaveToRepo);
		this.testClimbingAttemptsWithID =this.attemptRepository.saveAndFlush(attemptToSaveToRepo);


        this.ClimberToSaveToRepo = new Climber("96Wilkinson", "Tony", "Wilkinson", testClimbingAttemptSet);
        this.climberRepository.deleteAll();
		this.climberList.add(ClimberToSaveToRepo);
        this.climberToCheckTestAgainst = this.climberRepository.save(this.ClimberToSaveToRepo);
    }

    @Test
    public void testCreateClimber() {
        assertEquals(this.climberToCheckTestAgainst, this.service.addNewClimber(ClimberToSaveToRepo));
    }

    @Test
    public void testReadClimber() {
        assertThat(this.service.getAllClimber()).isEqualTo(this.climberList);
    }

    @Test
    public void testDeleteClimber() {

        assertThat(this.service.deleteClimber(this.climberToCheckTestAgainst.getId()))
                .isFalse();
    }

    @Test
    public void testFindClimberByID() {
        assertThat(this.service.findClimberById(this.climberToCheckTestAgainst.getId())).isEqualTo(this.climberToCheckTestAgainst);
    }

    @Test
    public void testUpdateClimber() {
        Climber newClimber = new Climber("AJohn123", "Avery", "Johnston", testClimbingAttemptSet);
        Climber updatedClimber = new Climber(newClimber.getUsername(), newClimber.getFirstname(), newClimber.getSurname(), newClimber.getClimbingAttempts());
        updatedClimber.setId(this.climberToCheckTestAgainst.getId());

        assertThat(this.service.updateClimber(newClimber, this.climberToCheckTestAgainst.getId())).isEqualTo(updatedClimber);
    }

}
