package persistance;

import static org.assertj.core.api.Assertions.assertThat;


import com.bae.persistence.domain.ClimbingAttempts;
import com.bae.persistence.repository.ClimbingAttemptRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.Application;
import com.bae.persistence.repository.ClimberRepository;
import com.bae.persistence.domain.Climber;

import java.util.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@DataJpaTest
public class ClimberRepoTest {


	@Autowired
	private ClimberRepository climberRepository;

/*	private ClimbingAttemptRepository attemptRepository;*/

	private ClimbingAttempts testClimbingAttempt;

	private Set<ClimbingAttempts> testClimbingAttemptsSet = new HashSet<ClimbingAttempts>();

	private final String TEST_USER = "NivsValy";
	private final String TEST_FIRST = "Neeven";
	private final String TEST_SUR = "Valydon";

	private final Climber TEST_CLIMBER = new Climber(TEST_USER, TEST_FIRST, TEST_SUR, testClimbingAttemptsSet);

	private Climber testSavedClimber;

	@Before
	public void init() {
		this.climberRepository.deleteAll();
		this.testClimbingAttempt = new ClimbingAttempts(1,18,12,1996,3);
		/*this.attemptRepository.save(testClimbingAttempt);*/
		this.testClimbingAttemptsSet.add(testClimbingAttempt);
		this.testSavedClimber = this.climberRepository.save(this.TEST_CLIMBER);

	}

	@Test
	public void testFindByUserName() {
		assertThat(this.climberRepository.findByUsername(this.TEST_USER)).containsExactly(this.testSavedClimber);
	}

	@Test
	public void testFindByFirstName(){
		assertThat(this.climberRepository.findByFirstname(this.TEST_FIRST)).containsExactly(this.testSavedClimber);
	}

	@Test
	public void testFindBySurName(){
		assertThat(this.climberRepository.findBySurname(this.TEST_SUR)).containsExactly(this.testSavedClimber);
	}


}

