package com.bae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.bae.persistence.repository.ClimberRepository;
import com.bae.persistence.repository.ClimbingAttemptRepository;
import com.bae.persistence.domain.Climber;
import com.bae.persistence.domain.ClimbingAttempts;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(Application.class, args);
		ClimberRepository climberRepo = app.getBean(ClimberRepository.class);
		ClimbingAttemptRepository climbingAttemptRepo = app.getBean(ClimbingAttemptRepository.class);
		climberRepo.save(new Climber("Scrappy","John", "Gordon"));
		climberRepo.save(new Climber("jh447","Jordan","Harry"));
		climbingAttemptRepo.save(new ClimbingAttempts(1,1,1996,1,2));
	}

}
