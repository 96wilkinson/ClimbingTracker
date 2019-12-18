package com.BAE.Bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BAE.Persistence.domain.Climber;
import com.BAE.Persistence.Repository.ClimberRepository;

@Service
public class ClimberService {

	private ClimberRepository climberRepo;

	@Autowired
	public ClimberService(ClimberRepository climberRepo) {
		this.climberRepo = climberRepo;
	}

	public List<Climber> getAllClimber() {
		return climberRepo.findAll();
	}

	public Climber addNewClimber(Climber climbers) {
		return climberRepo.save(climbers);
	}

	public Climber updateClimber(Climber climbers) {
		return climberRepo.save(climbers);
	}

	public String deleteClimber(Long climberId) {
		climberRepo.deleteById(climberId);
		return "Climber succesfully deleted";
	}
}