package rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bae.bussiness.ClimberService;
import com.bae.persistence.domain.Climber;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.rest.ClimberController;
@RunWith(SpringRunner.class)
public class ClimberControllerUnitTest {

    @InjectMocks
    private ClimberController controller;

    @Mock
    private ClimberService service;

    private List<Climber> climberList;

    private Climber testClimber;

    private Climber testClimberWithId;

    private final long id = 1L;

    @Before
    public void init() {
        this.climberList = new ArrayList<>();
        this.climberList.add(testClimber);
        this.testClimber = new Climber("96Wilkinson", "Tony", "Wilkinson");
        this.testClimberWithId = new Climber(testClimber.getUserName(), testClimber.getFirstName(),
                testClimber.getSurName());
        this.testClimberWithId.setId(id);
    }
    @Test
    public void createClimberTest() {
        when(this.service.addNewClimber(testClimber)).thenReturn(testClimberWithId);

        assertEquals(this.testClimberWithId, this.controller.addNewClimber(testClimber));

        verify(this.service, times(1)).addNewClimber(this.testClimber);
    }

    @Test
    public void deleteClimberTest() {
        this.controller.deleteClimber(id);

        verify(this.service, times(1)).deleteClimber(id);
    }

    @Test
    public void findClimberByIDTest() {
        when(this.service.findClimberById(this.id)).thenReturn(this.testClimberWithId);

        assertEquals(this.testClimberWithId, this.controller.getClimber(this.id));

        verify(this.service, times(1)).findClimberById(this.id);
    }
    @Test
    public void getAllClimbersTest() {

        when(service.getAllClimber()).thenReturn(this.climberList);

        assertFalse("Controller has found no Climbers", this.controller.getAllClimber().isEmpty());

        verify(service, times(1)).getAllClimber();
    }
    @Test
    public void updateClimbersTest() {
        // given
        Climber newClimber = new Climber("Sir Duckington esq.", "Blue", "Duckington Manor");
        Climber updatedClimber = new Climber(newClimber.getUserName(), newClimber.getFirstName(), newClimber.getSurName());
        updatedClimber.setId(this.id);

        when(this.service.updateClimber(newClimber, this.id)).thenReturn(updatedClimber);

        assertEquals(updatedClimber, this.controller.updateClimber(this.id, newClimber));

        verify(this.service, times(1)).updateClimber(newClimber, this.id);
    }
}
