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

import com.bae.Bussiness.ClimberService;
import com.bae.Persistence.domain.Climber;

@RestController
@RequestMapping("/climberapp")
public class ClimberController {

	private ClimberService climberService;

	@Autowired
	public ClimberController(ClimberService climberService) {
		this.climberService = climberService;
	}

	@GetMapping("/climber")
	public List<Climber> getAllClimber() {
		return climberService.getAllClimber();
	}

	@PostMapping("/climber")
	public Climber addNewClimber(@RequestBody Climber climber) {
		return climberService.addNewClimber(climber);
	}

	@PutMapping("/climber")
	public Climber updateClimber(@RequestBody Climber climber,Long climberId) {
		return climberService.updateClimber(climber, climberId);
	}

	@DeleteMapping("/climber/{id}")
	public void deleteClimber(@PathVariable(value = "id") Long id) {
		this.climberService.deleteClimber(id);
	}

}