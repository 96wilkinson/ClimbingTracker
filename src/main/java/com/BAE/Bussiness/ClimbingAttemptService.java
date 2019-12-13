package com.BAE.Bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BAE.Persistence.Repository.ClimbingAttemptRepository;
import com.BAE.Persistence.domain.ClimbingAttempts;


@Service
public class ClimbingAttemptService {

	private ClimbingAttemptRepository climbingAttemptRepo;

	@Autowired
	public ClimbingAttemptService(ClimbingAttemptRepository climbingAttemptRepo) {
		this.climbingAttemptRepo = climbingAttemptRepo;
	}

	public List<ClimbingAttempts> getAllClimbingAttempts() {
}

	public ClimbingAttempts addNewClimbingAttempts(ClimbingAttempts climbingattempts) {
		return climbingAttemptRepo.save(climbingattempts);
	}

	public ClimbingAttempts updateClimbingAttempt(ClimbingAttempts climbers) {
		return climbingAttemptRepo.save(climbers);
	}

	public String deleteClimbingAttempt(Long id) {
		climbingAttemptRepo.deleteById(id);
		return "Climbing Attempt succesfully deleted";
	}
}

