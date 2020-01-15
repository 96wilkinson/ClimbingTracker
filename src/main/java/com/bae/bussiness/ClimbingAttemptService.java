package com.bae.bussiness;

import java.util.List;

import com.bae.persistence.domain.Climber;
import exceptions.ClimbingAttemptNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.persistence.repository.ClimbingAttemptRepository;
import com.bae.persistence.domain.ClimbingAttempts;

@Service
public class ClimbingAttemptService {

    private ClimbingAttemptRepository AttemptRepo;

    private ClimberService ClimberService;

    @Autowired
    public ClimbingAttemptService(ClimbingAttemptRepository climbingAttemptRepo
            , ClimberService ClimberService) {
        this.AttemptRepo = climbingAttemptRepo;
        this.ClimberService = ClimberService;
    }

    public List<ClimbingAttempts> getAllClimbingAttempts() {
        return AttemptRepo.findAll();
    }

    public ClimbingAttempts findClimbingAttemptsById(Long id) {
        return this.AttemptRepo.findById(id).orElseThrow(() -> new ClimbingAttemptNotFoundException());
    }

    public ClimbingAttempts addNewClimbingAttempts(ClimbingAttempts climber, Long climberId) {
        return AttemptRepo.save(climber);
    }

    public ClimbingAttempts updateClimbingAttempt(ClimbingAttempts climber, Long id) {
        ClimbingAttempts toUpdate = findClimbingAttemptsById(id);
        toUpdate.setDay(climber.getDay());
        toUpdate.setMonth(climber.getMonth());
        toUpdate.setYear(climber.getYear());
        toUpdate.setDifficulty(climber.getDifficulty());
        toUpdate.setTimeSpent(climber.getTimeSpent());
        return this.AttemptRepo.save(toUpdate);
    }


/*	public ClimbingAttempts addClimberToClimbingAttempts(long id, Climber climber) {
		ClimbingAttempts toUpdate = findClimbingAttemptsById(id);
		toUpdate.getClimbers().add(climber);
		return this.AttemptRepo.saveAndFlush(toUpdate);
	}*/

    public boolean deleteClimbingAttempt(Long climbAttemptId) {
        if (!this.AttemptRepo.existsById(climbAttemptId)) {
            throw new ClimbingAttemptNotFoundException();
        }
        this.AttemptRepo.deleteById(climbAttemptId);
        return this.AttemptRepo.existsById(climbAttemptId);
    }
}
