package persistance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.Application;
import com.bae.Persistence.Repository.ClimberRepository;
import com.bae.Persistence.domain.Climber;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@DataJpaTest
public class ClimberRepoTest {


	@Autowired
	private ClimberRepository repo;

	private final String TEST_USER = "NivsValy";

	private final Climber TEST_CLIMBER = new Climber(TEST_USER, "Neeven", "Valydon");

	private Climber testSavedClimber;

	@Before
	public void init() {
		this.repo.deleteAll();
		this.testSavedClimber = this.repo.save(this.TEST_CLIMBER);
	}

	@Test
	public void testFindByName() {
		assertThat(this.repo.findByUserName(this.TEST_USER)).containsExactly(this.testSavedClimber);
	}

}

