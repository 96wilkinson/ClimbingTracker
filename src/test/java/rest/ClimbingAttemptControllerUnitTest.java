package rest;

import com.bae.bussiness.ClimbingAttemptService;
import com.bae.persistence.domain.ClimbingAttempts;
import com.bae.rest.ClimbingAttemptController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ClimbingAttemptControllerUnitTest {

    @InjectMocks
    private ClimbingAttemptController controller;

    @Mock
    private ClimbingAttemptService service;

    private List<ClimbingAttempts> climbingAttemptsList;

    private ClimbingAttempts testClimbingAttempt;

    private ClimbingAttempts testClimbingAttemptWithId;

    private final long id = 1L;

    @Before
    public void init() {
        this.climbingAttemptsList = new ArrayList<>();
        this.climbingAttemptsList.add(testClimbingAttempt);
        this.testClimbingAttempt = new ClimbingAttempts(18,12,1996,3,4);
        this.testClimbingAttemptWithId = new ClimbingAttempts(testClimbingAttempt.getDay(), testClimbingAttempt.getMonth(),
                testClimbingAttempt.getYear(),testClimbingAttempt.getDifficulty(),testClimbingAttempt.getTimeSpent());
        this.testClimbingAttemptWithId.setId(id);
    }
/*    @Test
    public void createClimbingAttemptTest() {
        when(this.service.addNewClimbingAttempts(testClimbingAttempt,Long)).thenReturn(testClimbingAttemptWithId);

        assertEquals(this.testClimbingAttemptWithId, this.controller.addNewClimbingAttempts(testClimbingAttempt));

        verify(this.service, times(1)).addNewClimbingAttempts(this.testClimbingAttempt);
    }*/

    @Test
    public void deleteClimbingAttemptTest() {
        this.controller.deleteClimbingAttempt(id);

        verify(this.service, times(1)).deleteClimbingAttempt(id);
    }

    @Test
    public void findClimbingAttemptByIDTest() {
        when(this.service.findClimbingAttemptsById(this.id)).thenReturn(this.testClimbingAttemptWithId);

        assertEquals(this.testClimbingAttemptWithId, this.controller.getClimbingAttempts(this.id));

        verify(this.service, times(1)).findClimbingAttemptsById(this.id);
    }
    @Test
    public void getAllClimbingAttemptsTest() {

        when(service.getAllClimbingAttempts()).thenReturn(this.climbingAttemptsList);

        assertFalse("Controller has found no Climbers", this.controller.getAllClimbingAttempts().isEmpty());

        verify(service, times(1)).getAllClimbingAttempts();
    }
    @Test
    public void updateClimbingAttemptsTest() {
        // given
        ClimbingAttempts newClimbingAttempt = new ClimbingAttempts(22,11,1997,3,5);
        ClimbingAttempts updatedClimbingAttempt = new ClimbingAttempts(newClimbingAttempt.getDay(),newClimbingAttempt.getMonth()
                ,newClimbingAttempt.getYear(),newClimbingAttempt.getDifficulty(),newClimbingAttempt.getTimeSpent());
        updatedClimbingAttempt.setId(this.id);

        when(this.service.updateClimbingAttempt(newClimbingAttempt, this.id)).thenReturn(updatedClimbingAttempt);

        assertEquals(updatedClimbingAttempt, this.controller.updateClimber(this.id, newClimbingAttempt));

        verify(this.service, times(1)).updateClimbingAttempt(newClimbingAttempt, this.id);
    }
}
