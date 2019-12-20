package com.bae.Rest;

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

import com.bae.Bussiness.ClimbingAttemptService;
import com.bae.Persistence.domain.ClimbingAttempts;

@RestController
@RequestMapping("/climberapp")
public class ClimbingAttemptController {

	private ClimbingAttemptService climbingAttemptService;

	@Autowired
	public ClimbingAttemptController(ClimbingAttemptService climbingAttemptService) {
		this.climbingAttemptService = climbingAttemptService;
	}

	@GetMapping("/climbingAttempt")
	public List<ClimbingAttempts> getAllClimbingAttempts() {
		return climbingAttemptService.getAllClimbingAttempts();
	}

	@PostMapping("/climbingAttempt")
	public ClimbingAttempts addNewClimber(@RequestBody ClimbingAttempts climbingAttempts) {
		return climbingAttemptService.addNewClimbingAttempts(climbingAttempts);
	}

	@PutMapping("/climbingAttempt")
	public ClimbingAttempts updateClimber(@RequestBody ClimbingAttempts climbingAttempts) {
		return climbingAttemptService.updateClimbingAttempt(climbingAttempts);
	}

	@DeleteMapping("/climbingAttempt/{id}")
	public String deleteClimbingAttempt(@PathVariable(value = "id") Long id) {
		return climbingAttemptService.deleteClimbingAttempt(id);
	}

}