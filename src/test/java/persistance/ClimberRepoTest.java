package persistance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.Application;
import com.bae.persistence.repository.ClimberRepository;
import com.bae.persistence.domain.Climber;

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
		MockitoAnnotations.initMocks(this);
		this.repo.deleteAll();
		this.testSavedClimber = this.repo.save(this.TEST_CLIMBER);

	}

	@Test
	public void testFindByName() {
		assertThat(this.repo.findByUsername(this.TEST_USER)).containsExactly(this.testSavedClimber);
	}


}

