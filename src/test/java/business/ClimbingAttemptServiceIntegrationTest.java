package business;

import com.bae.Application;
import com.bae.bussiness.ClimbingAttemptService;
import com.bae.persistence.domain.Climber;
import com.bae.persistence.domain.ClimbingAttempts;
import com.bae.persistence.repository.ClimbingAttemptRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
public class ClimbingAttemptServiceIntegrationTest {

	@Autowired
	private ClimbingAttemptService service;

	@Autowired
	private ClimbingAttemptRepository repo;

	private ClimbingAttempts testClimbingAttempt;

	private ClimbingAttempts testClimbingAttemptWithID;
	
	private List<ClimbingAttempts> climbingAttempts;

	@Before
	public void init() {

		this.testClimbingAttempt = new ClimbingAttempts(18,12,1996,3,5);
		this.repo.deleteAll();
		this.testClimbingAttemptWithID = this.repo.save(this.testClimbingAttempt);
	}

	@Test
	public void testCreateClimbingAttempt() {
		assertEquals(this.testClimbingAttemptWithID, this.service.addNewClimbingAttempts(testClimbingAttempt));
	}

	@Test
	public void testReadClimbingAttempt() {
		assertThat(this.service.getAllClimbingAttempts()).isEqualTo(Arrays.asList(new ClimbingAttempts[] { this.testClimbingAttemptWithID}));
	}

	@Test
	public void testDeleteClimbingAttempt() {
		assertThat(this.service.deleteClimbingAttempt(this.testClimbingAttemptWithID
				.getId())).isFalse();
	}

	@Test
	public void testFindClimbingAttemptByID() {
		assertThat(this.service.findClimbingAttemptsById(this.testClimbingAttemptWithID.getId())).isEqualTo(this.testClimbingAttemptWithID);
	}

	@Test
	public void testUpdateClimbingAttempt() {
		ClimbingAttempts newClimbingAttempt = new ClimbingAttempts(18,12,1996,3,5);
		ClimbingAttempts updatedClimbingAttempts = new ClimbingAttempts(newClimbingAttempt.getDay(),newClimbingAttempt.getMonth()
				,newClimbingAttempt.getYear(),newClimbingAttempt.getDifficulty(),newClimbingAttempt.getTimeSpent());
		updatedClimbingAttempts.setId(this.testClimbingAttemptWithID.getId());

		assertThat(this.service.updateClimbingAttempt(
				newClimbingAttempt, this.testClimbingAttemptWithID.getId())).isEqualTo(updatedClimbingAttempts);
	}

}
