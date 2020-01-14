package persistance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import com.bae.Application;
import com.bae.persistence.domain.Climber;
import com.bae.persistence.domain.ClimbingAttempts;
import com.bae.persistence.repository.ClimbingAttemptRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@DataJpaTest
public class ClimbingAttemptRepoTest {

    @Autowired
    private ClimbingAttemptRepository repo;

    private final ClimbingAttempts TEST_Attempt = new ClimbingAttempts(18,12,1996, 3, 4);

    private ClimbingAttempts testSavedAttempt;

    @Before
    public void init() {
        this.repo.deleteAll();
        this.testSavedAttempt = this.repo.save(this.TEST_Attempt);
    }

    @Test
    public void testFindById() {
        assertThat(this.repo.findClimbingAttemptsById(this.TEST_Attempt)).containsExactly(this.testSavedAttempt);
    }

    @Test
    public void testFindByDay() {
        assertThat(this.repo.findClimbingAttemptsByDay(this.TEST_Attempt)).containsExactly(this.testSavedAttempt);
    }

    @Test
    public void testFindByMonth() {
        assertThat(this.repo.findClimbingAttemptsByMonth(this.TEST_Attempt)).containsExactly(this.testSavedAttempt);
    }

    @Test
    public void testFindByYear() {
        assertThat(this.repo.findClimbingAttemptsByYear(this.TEST_Attempt)).containsExactly(this.testSavedAttempt);
    }

    @Test
    public void testFindByDifficulty() {
        assertThat(this.repo.findClimbingAttemptsByDifficulty(this.TEST_Attempt)).containsExactly(this.testSavedAttempt);
    }

    @Test
    public void testFindByTimeSpent() {
        assertThat(this.repo.findClimbingAttemptsByTimeSpent(this.TEST_Attempt)).containsExactly(this.testSavedAttempt);
    }

}
