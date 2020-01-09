package com.bae.bussiness;

import java.util.List;

import exceptions.ClimbingAttemptNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.persistence.repository.ClimbingAttemptRepository;
import com.bae.persistence.domain.ClimbingAttempts;

@Service
public class ClimbingAttemptService {
	@Autowired
	private ClimbingAttemptRepository climbingAttemptRepo;

	
	public ClimbingAttemptService(ClimbingAttemptRepository climbingAttemptRepo) {
		this.climbingAttemptRepo = climbingAttemptRepo;
	}

	public List<ClimbingAttempts> getAllClimbingAttempts() {
		return climbingAttemptRepo.findAll();
	}

	public ClimbingAttempts findClimbingAttemptsById(Long id) {
		return this.climbingAttemptRepo.findById(id).orElseThrow(() -> new ClimbingAttemptNotFoundException());
	}

	public ClimbingAttempts addNewClimbingAttempts(ClimbingAttempts climbingattempts) {
		return climbingAttemptRepo.save(climbingattempts);
	}

	public ClimbingAttempts updateClimbingAttempt(ClimbingAttempts climbingattempts, Long id) {
		ClimbingAttempts toUpdate = findClimbingAttemptsById(id);
		toUpdate.setDay(climbingattempts.getDay());
		toUpdate.setMonth(climbingattempts.getMonth());
		toUpdate.setYear(climbingattempts.getYear());
		toUpdate.setDifficulty(climbingattempts.getDifficulty());
		toUpdate.setTimeSpent(climbingattempts.getTimeSpent());
		return this.climbingAttemptRepo.save(toUpdate);
	}

	public boolean deleteClimbingAttempt(Long climbAttemptId) {
		if (!this.climbingAttemptRepo.existsById(climbAttemptId)) {
			throw new ClimbingAttemptNotFoundException();
		}
		this.climbingAttemptRepo.deleteById(climbAttemptId);
		return this.climbingAttemptRepo.existsById(climbAttemptId);
	}
}
