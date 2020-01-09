package business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.bae.bussiness.ClimberService;
import com.bae.persistence.repository.ClimberRepository;
import com.bae.persistence.domain.Climber;

@RunWith(MockitoJUnitRunner.class)
public class ClimberServiceUnitTests {

	@InjectMocks
	private ClimberService service;

	@Mock
	private ClimberRepository repo;

	private List<Climber> climberList;

	private Climber testClimber;

	private Climber testClimberWithID;

	private final long id = 1L;

	@Before
	public void init() {
		this.climberList = new ArrayList<>();
		this.climberList.add(testClimber);
		this.testClimber = new Climber("96Wilkinson", "Tony", "Wilkinson");
		this.testClimberWithID = new Climber(testClimber.getUsername(), testClimber.getFirstname(),
				testClimber.getSurname());
		this.testClimberWithID.setId(id);
	}

	@Test
	public void createClimberTest() {
		when(this.repo.save(testClimber)).thenReturn(testClimberWithID);

		assertEquals(this.testClimberWithID, this.service.addNewClimber(testClimber));

		verify(this.repo, times(1)).save(this.testClimber);
	}

	@Test
	public void deleteClimberTest() {
		when(this.repo.existsById(id)).thenReturn(true, false);

		this.service.deleteClimber(id);

		verify(this.repo, times(1)).deleteById(id);
		verify(this.repo, times(2)).existsById(id);
	}

	@Test
	public void findClimberByIDTest() {
		when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testClimberWithID));

		assertEquals(this.testClimberWithID, this.service.findClimberById(this.id));

		verify(this.repo, times(1)).findById(this.id);
	}

	@Test
	public void readClimberTest() {

		when(repo.findAll()).thenReturn(this.climberList);

		assertFalse("Controller has found no Climbers", this.service.getAllClimber().isEmpty());

		verify(repo, times(1)).findAll();
	}
}