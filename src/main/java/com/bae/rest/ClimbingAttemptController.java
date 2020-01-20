package com.bae.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.bussiness.ClimbingAttemptService;
import com.bae.persistence.domain.ClimbingAttempts;

@RestController
@RequestMapping("/ClimbingTracker")
public class ClimbingAttemptController {

	private ClimbingAttemptService climbingAttemptService;

	@Autowired
	public ClimbingAttemptController(ClimbingAttemptService climbingAttemptService) {
		this.climbingAttemptService = climbingAttemptService;
	}

	@GetMapping("/getAllClimbingAttempts")
	public List<ClimbingAttempts> getAllClimbingAttempts() {
		return climbingAttemptService.getAllClimbingAttempts();
	}

	@GetMapping("/getClimbingAttempt/{id}")
	public ClimbingAttempts getClimbingAttempts(@PathVariable Long id) { return this.climbingAttemptService.findClimbingAttemptsById(id); }

	@PostMapping("/createClimbingAttempt")
	public ClimbingAttempts addNewClimber(@RequestBody ClimbingAttempts climbingAttempts) {
		return climbingAttemptService.addNewClimbingAttempts(climbingAttempts);
	}

	@PutMapping("/updateClimbingAttempt/{id}")
	public ClimbingAttempts updateClimber(@PathVariable(value = "id") Long id,@RequestBody ClimbingAttempts climbingAttempts) {
		return climbingAttemptService.updateClimbingAttempt(climbingAttempts,id);
	}

	@DeleteMapping("/DeleteClimbingAttempt/{id}")
	public void deleteClimbingAttempt(@PathVariable(value = "id") Long id) {
		this.climbingAttemptService.deleteClimbingAttempt(id);
	}

}