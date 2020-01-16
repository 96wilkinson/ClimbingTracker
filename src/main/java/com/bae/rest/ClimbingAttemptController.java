package com.bae.rest;

import java.util.List;

import com.bae.persistence.domain.Climber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bae.bussiness.ClimbingAttemptService;
import com.bae.persistence.domain.ClimbingAttempts;

@RestController
@RequestMapping("/climberapp")
public class ClimbingAttemptController {

    private ClimbingAttemptService Service;

    @Autowired
    public ClimbingAttemptController(ClimbingAttemptService service) {
        super();
        this.Service = service;
    }

    @GetMapping("/getAllClimbingAttempts")
    public List<ClimbingAttempts> getAllClimbingAttempts() {
        return Service.getAllClimbingAttempts();
    }

    @GetMapping("/getClimbingAttempt/{id}")
    public ClimbingAttempts getClimbingAttempts(@PathVariable Long id) {
        return this.Service.findClimbingAttemptsById(id);
    }

    @PostMapping("/createClimbingAttempt/{id}")
    public ClimbingAttempts addNewClimbingAttempts(@RequestBody ClimbingAttempts addNewClimbingAttempts,
                                                   @PathVariable("id") Long id) {
        return Service.addNewClimbingAttempts(addNewClimbingAttempts, id);
    }

    @PutMapping("/updateClimbingAttempt/{id}")
    public ClimbingAttempts updateClimber(@PathVariable(value = "id") Long id, @RequestBody ClimbingAttempts climbingAttempts) {
        return Service.updateClimbingAttempt(climbingAttempts, id);
    }

/*	@PatchMapping("/updateClimbingAttempt/{id}")
	public ClimbingAttempts addClimberToClimbingAttempts(@PathVariable Long id, @RequestBody Climber climber)
	{
		return this.Service.addClimberToClimbingAttempts(id,climber);
	}*/


    @DeleteMapping("/DeleteClimbingAttempt/{id}")
    public void deleteClimbingAttempt(@PathVariable(value = "id") Long id) {
        this.Service.deleteClimbingAttempt(id);
    }

}
