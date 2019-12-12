package com.BAE.Bussiness;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BAE.Persistence.domain.Climbers; 
import com.BAE.Persistence.Repository.ClimberRepository;

@Service
public class ClimberService {

	private ClimberRepository climberRepo;

	public ClimberService(ClimberRepository ClimberRepo) {

	}

	public List<Climbers> getAllClimber() {
		if (climberRepo.findAll().isEmpty()) {
			setUpClimber();
		}
		return climberRepo.findAll();
	}

	private void setUpClimber() {
		Climbers john = new Climbers("Scrappy","John", "Gordon");
		Climbers jordan= new Climbers("Jh","Jordan", "Harry");
		climberRepo.save(john);
		climberRepo.save(jordan);
	}

	public Climbers addNewClimber(Climbers climber) {
		return climberRepo.save(climber);
	}

	public Climbers updateClimber(Climbers climber) {
		return climberRepo.save(climber);
	}

	public String deleteClimber(Long id) {
		climberRepo.deleteById(id);
		return "Climber succesfully deleted";
	}
}