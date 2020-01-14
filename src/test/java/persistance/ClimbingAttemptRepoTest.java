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

    private ClimbingAttempts testClimbingAttempt;

    private Set<ClimbingAttempts> testClimbingAttemptsSet = new HashSet<ClimbingAttempts>();

    private final int DAY = 18;
    private final int MONTH = 12;
    private final int YEAR = 1996;
    private final int DIFFICULTY = 3;
    private final int TIME_SPENT = 5;

    private final ClimbingAttempts TEST_ATTEMPT = new ClimbingAttempts(DAY
            ,MONTH,YEAR,DIFFICULTY,TIME_SPENT);


    @Before
    public void init() {
        this.repo.deleteAll();
        this.testClimbingAttempt = new ClimbingAttempts(18,12,1996,3,5);
        this.testClimbingAttemptsSet.add(testClimbingAttempt);
        this.repo.save(this.TEST_ATTEMPT);

    }

    @Test
    public void testFindById() {
        assertThat(this.repo.findClimbingAttemptsById(this.TEST_ATTEMPT)).isEqualTo(this.testClimbingAttemptsSet);
    }

    @Test
    public void testFindByDay() {
        assertThat(this.repo.findClimbingAttemptsByDay(this.TEST_ATTEMPT)).isEqualTo(this.testClimbingAttemptsSet);
    }

    @Test
    public void testFindByMonth() {
        assertThat(this.repo.findClimbingAttemptsByMonth(this.TEST_ATTEMPT)).isEqualTo(this.testClimbingAttemptsSet);
    }

    @Test
    public void testFindByYear() {
        assertThat(this.repo.findClimbingAttemptsByYear(this.TEST_ATTEMPT)).isEqualTo(this.testClimbingAttemptsSet);
    }

    @Test
    public void testFindByDifficulty() {
        assertThat(this.repo.findClimbingAttemptsByDifficulty(this.TEST_ATTEMPT)).isEqualTo(this.testClimbingAttemptsSet);
    }

    @Test
    public void testFindByTimeSpent() {
        assertThat(this.repo.findClimbingAttemptsByTimeSpent(this.TEST_ATTEMPT)).isEqualTo(this.testClimbingAttemptsSet);
    }

}
