package com.BAE.Bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BAE.Persistence.Repository.ClimbingAttemptRepository;
import com.BAE.Persistence.domain.ClimbingAttempts;

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

	public ClimbingAttempts addNewClimbingAttempts(ClimbingAttempts climbingattempts) {
		return climbingAttemptRepo.save(climbingattempts);
	}

	public ClimbingAttempts updateClimbingAttempt(ClimbingAttempts climbingattempts) {
		return climbingAttemptRepo.save(climbingattempts);
	}

	public String deleteClimbingAttempt(Long climbAttemptId) {
		climbingAttemptRepo.deleteById(climbAttemptId);
		return "Climbing Attempt succesfully deleted";
	}
}
