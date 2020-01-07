/*
package business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

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
	private ClimberRepository repo;

	private Climber testClimber;

	private Climber testClimberWithID;
	
	private List<Climber> climbers;

	@Before
	public void init() {

		this.testClimber = new Climber("96Wilkinson", "Tony", "Wilkinson");
		this.repo.deleteAll();
		this.testClimberWithID = this.repo.save(this.testClimber);
	}

	@Test
	public void testCreateClimber() {
		assertEquals(this.testClimberWithID, this.service.addNewClimber(testClimber));
	}

	@Test
	public void testReadClimber() {
		assertThat(this.service.getAllClimber()).isEqualTo(Arrays.asList(new Climber[] { this.testClimberWithID }));
	}

	@Test
	public void testDeleteClimber() {

		assertThat(this.service.deleteClimber(this.testClimberWithID.getId()))
				.isFalse();
	}

	@Test
	public void testFindClimberByID() {
		assertThat(this.service.findClimberById(this.testClimberWithID.getId())).isEqualTo(this.testClimberWithID);
	}

	@Test
	public void testUpdateClimber() {
		Climber newClimber = new Climber("AJohn123", "Avery", "Johnston");
		Climber updatedClimber = new Climber(newClimber.getUserName(), newClimber.getFirstName(),newClimber.getSurName());
		updatedClimber.setId(this.testClimberWithID.getId());

		assertThat(this.service.updateClimber(newClimber, this.testClimberWithID.getId())).isEqualTo(updatedClimber);
	}

}
*/
