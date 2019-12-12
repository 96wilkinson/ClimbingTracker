package com.BAE.Rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BAE.business.ClimberService;
import com.BAE.Persistence.Domain.Climber;

@RestController
@RequestMapping("/climberapp")
public class ClimberController {

	private ClimberService climberService;

	public ClimberController(ClimberService climberService) {
		this.climberService = climberService;
	}

	@GetMapping("/climber")
	public List<Climber> getAllClimber() {
		return climberService.getAllClimber();
	}

	@PostMapping("/climber")
	public Climber addNewClimber(@RequestBody Climber climber) {
		return climberService.addNewTrainer(climber);
	}

	@PutMapping("/climber")
	public Climber updateClimber(@RequestBody Climber climber) {
		return climberService.updateTrainer(climber);
	}

	@DeleteMapping("/climber/{id}")
	public String deleteClimber(@PathVariable(value = "id") Long id) {
		return climberService.deleteClimber(id);
	}

}