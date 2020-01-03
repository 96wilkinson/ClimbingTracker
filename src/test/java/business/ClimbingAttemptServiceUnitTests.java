package business;

import com.bae.bussiness.ClimbingAttemptService;
import com.bae.persistence.domain.Climber;
import com.bae.persistence.domain.ClimbingAttempts;
import com.bae.persistence.repository.ClimbingAttemptRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ClimbingAttemptServiceUnitTests {

	@InjectMocks
	private ClimbingAttemptService service;

	@Mock
	private ClimbingAttemptRepository repo;

	private List<ClimbingAttempts> climbingAttemptList;

	private ClimbingAttempts testClimbingAttempt;

	private ClimbingAttempts testClimbingAttemptWithID;

	private final long id = 1L;

	@Before
	public void init() {
		this.climbingAttemptList = new ArrayList<>();
		this.climbingAttemptList.add(testClimbingAttempt);
		this.testClimbingAttempt = new ClimbingAttempts(18,12,1996,3,5);
		this.testClimbingAttemptWithID = new ClimbingAttempts(testClimbingAttempt.getDay(),testClimbingAttempt.getMonth()
				,testClimbingAttempt.getYear(),testClimbingAttempt.getDifficulty(),testClimbingAttempt.getTimeSpent());
		this.testClimbingAttemptWithID.setId(id);
	}

	@Test
	public void createClimberTest() {
		when(this.repo.save(testClimbingAttempt)).thenReturn(testClimbingAttemptWithID);

		assertEquals(this.testClimbingAttemptWithID, this.service.addNewClimbingAttempts(testClimbingAttempt));

		verify(this.repo, times(1)).save(this.testClimbingAttempt);
	}

	@Test
	public void deleteClimberTest() {
		when(this.repo.existsById(id)).thenReturn(true, false);

		this.service.deleteClimbingAttempt(id);

		verify(this.repo, times(1)).deleteById(id);
	}

	@Test
	public void findClimberByIDTest() {
		when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testClimbingAttemptWithID));

		assertEquals(this.testClimbingAttemptWithID, this.service.findClimbingAttemptsById(this.id));

		verify(this.repo, times(1)).findById(this.id);
	}

	@Test
	public void readClimberTest() {

		when(repo.findAll()).thenReturn(this.climbingAttemptList);

		assertFalse("Controller has found no Climbers", this.service.getAllClimbingAttempts().isEmpty());

		verify(repo, times(1)).findAll();
	}
}