package persistance;

import static org.assertj.core.api.Assertions.assertThat;


import com.bae.persistence.domain.ClimbingAttempts;
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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@DataJpaTest
public class ClimberRepoTest {


	@Autowired
	private ClimberRepository repo;
	private Set<ClimbingAttempts> TEST_Attempt = new HashSet<ClimbingAttempts>();
	Integer[] array = new Integer[]{ 18,12,1996, 3, 4};
//	TEST_Attempt.addAll(Arrays.asL);
//	array.
	private final String TEST_USER = "NivsValy";
	private final String TEST_FIRST = "Neeven";
	private final String TEST_SUR = "Valydon";

	private final Climber TEST_CLIMBER = new Climber(TEST_USER, TEST_FIRST, TEST_SUR,TEST_Attempt);


	private Climber testSavedClimber;

	@Before
	public void init() {
		this.repo.deleteAll();
		this.testSavedClimber = this.repo.save(this.TEST_CLIMBER);
	}

	@Test
	public void testFindByUserName() {
		assertThat(this.repo.findByUsername(this.TEST_USER)).containsExactly(this.testSavedClimber);
	}

	@Test
	public void testFindByFirstName(){
		assertThat(this.repo.findByFirstname(this.TEST_FIRST)).containsExactly(this.testSavedClimber);
	}

	@Test
	public void testFindBySurName(){
		assertThat(this.repo.findBySurname(this.TEST_SUR)).containsExactly(this.testSavedClimber);
	}


}

