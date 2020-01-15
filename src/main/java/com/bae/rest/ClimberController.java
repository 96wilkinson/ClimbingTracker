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

@RestController
@RequestMapping("/climberapp")
public class ClimberController {

    private ClimberService service;

    @Autowired
    public ClimberController(ClimberService climberService) {
        this.service = climberService;
    }

    @GetMapping("/getAll")
    public List<Climber> getAllClimber() {
        return service.getAllClimber();
    }

    @GetMapping("/get/{id}")
    public Climber getClimber(@PathVariable Long id) {
        return this.service.findClimberById(id);
    }

    @PostMapping("/createClimber")
    public Climber addNewClimber(@RequestBody Climber climber) {

        return service.addNewClimber(climber);
    }

    @PutMapping("/updateClimber/{id}")
    public Climber updateClimber(@PathVariable(value = "id") Long id, @RequestBody Climber climber) {
        return service.updateClimber(climber, id);
    }

    @DeleteMapping("/DeleteClimber/{id}")
    public void deleteClimber(@PathVariable(value = "id") Long id) {
        this.service.deleteClimber(id);
    }

}