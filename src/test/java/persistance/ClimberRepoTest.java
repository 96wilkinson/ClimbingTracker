/*
package persistance;

import static org.assertj.core.api.Assertions.assertThat;


import com.bae.persistence.domain.ClimbingAttempts;
import com.bae.persistence.repository.ClimbingAttemptRepository;
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

import java.util.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@DataJpaTest
public class ClimberRepoTest {


    @Autowired
    private ClimberRepository climberRepository;

    private final int DAY = 18;
    private final int MONTH = 12;
    private final int YEAR = 1996;
    private final int DIFFICULTY = 3;
    private final int TIME_SPENT = 5;

    private final ClimbingAttempts testClimbingAttempt = new ClimbingAttempts(DAY
            , MONTH, YEAR, DIFFICULTY, TIME_SPENT);

    private Set<ClimbingAttempts> testClimbingAttemptsSet = new HashSet<ClimbingAttempts>();

    private ClimbingAttemptRepository attemptRepository;

    private final String TEST_USER = "NivsValy";
    private final String TEST_FIRST = "Neeven";
    private final String TEST_SUR = "Valydon";

    private final Climber climberToSaveToRepo = new Climber(TEST_USER, TEST_FIRST, TEST_SUR, testClimbingAttemptsSet);

    private final Climber climberToTestAgainst = new Climber("NivsValy", "Neeven", "Valydon", testClimbingAttemptsSet);


    @Before
    public void init() {
        this.climberRepository.deleteAll();

        this.attemptRepository.save(testClimbingAttempt);

        this.testClimbingAttemptsSet.add(testClimbingAttempt);

        this.climberRepository.save(this.climberToSaveToRepo);

        this.climberToTestAgainst.setId(climberToSaveToRepo.getId());


    }

    @Test
    public void testFindByUserName() {
        assertThat(this.climberRepository.findByUsername(this.climberToSaveToRepo.getUsername())).containsExactly(this.climberToTestAgainst);
    }

    @Test
    public void testFindByFirstName() {
        assertThat(this.climberRepository.findByFirstname(this.climberToSaveToRepo.getFirstname())).containsExactly(this.climberToTestAgainst);
    }

    @Test
    public void testFindBySurName() {
        assertThat(this.climberRepository.findBySurname(this.climberToSaveToRepo.getSurname())).containsExactly(this.climberToTestAgainst);
    }


}

*/
