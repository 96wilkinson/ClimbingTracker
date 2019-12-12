package com.BAE.Bussiness;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BAE.Persistence.Domain.Climber;
import com.BAE.Persistence.Repository.ClimberRepository;

@Service
public class ClimberService {

	private ClimberRepository climberRepo;

	public ClimberService(ClimberRepository ClimberRepo) {
		this.climberRepo = climberRepo;
	}

	public List<Climber> getAllClimber() {
		if (climberRepo.findAll().isEmpty()) {
			setUpClimber();
		}
		return climberRepo.findAll();
	}

	private void setUpClimber() {
		Climber john = new Climber("John", "Gordon");
		Climber chris = new Climber("Chris", "Perrins");
		climberRepo.save(john);
		climberRepo.save(chris);
	}

	public Climber addNewClimber(Climber climber) {
		return climberRepo.save(climber);
	}

	public Trainer updateClimber(Climber climber) {
		return climberRepo.save(climber);
	}

	public String deleteClimber(Long id) {
		climberRepo.deleteById(id);
		return "Climber succesfully deleted";
	}
}