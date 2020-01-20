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

import com.bae.bussiness.ClimberService;
import com.bae.persistence.domain.Climber;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/ClimbingTracker")
public class ClimberController {

	private ClimberService climberService;

	@Autowired
	public ClimberController(ClimberService climberService) {
		this.climberService = climberService;
	}

	@GetMapping("/getAll")
	public List<Climber> getAllClimber() {
		return climberService.getAllClimber();
	}

	@GetMapping("/get/{id}")
	public Climber getClimber(@PathVariable Long id) { return this.climberService.findClimberById(id); }

	@PostMapping("/createClimber")
	public Climber addNewClimber(@RequestBody Climber climber) {

		return climberService.addNewClimber(climber);
	}

	@PutMapping("/updateClimber/{id}")
	public Climber updateClimber(@PathVariable(value = "id") Long id,@RequestBody Climber climber) {
		return climberService.updateClimber(climber, id);
	}

	@DeleteMapping("/DeleteClimber/{id}")
	public void deleteClimber(@PathVariable(value = "id") Long id) {
		this.climberService.deleteClimber(id);
	}

}