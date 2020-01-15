package persistance;

import com.bae.Application;
import com.bae.persistence.domain.ClimbingAttempts;
import com.bae.persistence.repository.ClimbingAttemptRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@DataJpaTest
public class ClimbingAttemptRepoTest {

    @Autowired
    private ClimbingAttemptRepository repo;

    private final int DAY = 18;
    private final int MONTH = 12;
    private final int YEAR = 1996;
    private final int DIFFICULTY = 3;
    private final int TIME_SPENT = 5;

    private final ClimbingAttempts attemptToSaveToRepo = new ClimbingAttempts(DAY
            , MONTH, YEAR, DIFFICULTY, TIME_SPENT);

    private ClimbingAttempts testClimbingAttempt = new ClimbingAttempts(18, 12, 1996, 3, 5);

    private Set<ClimbingAttempts> testClimbingAttemptsSet = new HashSet<ClimbingAttempts>();

    @Before
    public void init() {
        this.repo.deleteAll();
        this.repo.save(this.attemptToSaveToRepo);

        testClimbingAttempt.setId(attemptToSaveToRepo.getId());
        this.testClimbingAttemptsSet.add(testClimbingAttempt);
    }

    @Test
    public void testFindById() {
        assertThat(this.repo.findClimbingAttemptsById(this.attemptToSaveToRepo.getId())).isEqualTo(this.testClimbingAttemptsSet);
    }

    @Test
    public void testFindByDay() {
        assertThat(this.repo.findClimbingAttemptsByDay(this.attemptToSaveToRepo.getDay())).isEqualTo(this.testClimbingAttemptsSet);
    }

    @Test
    public void testFindByMonth() {
        assertThat(this.repo.findClimbingAttemptsByMonth(this.attemptToSaveToRepo.getMonth())).isEqualTo(this.testClimbingAttemptsSet);
    }

    @Test
    public void testFindByYear() {
        assertThat(this.repo.findClimbingAttemptsByYear(this.attemptToSaveToRepo.getYear())).isEqualTo(this.testClimbingAttemptsSet);
    }

    @Test
    public void testFindByDifficulty() {
        assertThat(this.repo.findClimbingAttemptsByDifficulty(this.attemptToSaveToRepo.getDifficulty())).isEqualTo(this.testClimbingAttemptsSet);
    }

    @Test
    public void testFindByTimeSpent() {
        assertThat(this.repo.findClimbingAttemptsByTimeSpent(this.attemptToSaveToRepo.getTimeSpent())).isEqualTo(this.testClimbingAttemptsSet);
    }
}
