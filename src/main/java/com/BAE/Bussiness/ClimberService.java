package com.bae.Bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.Persistence.Repository.ClimberRepository;
import com.bae.Persistence.domain.Climber;

import Exceptions.ClimberNotFoundException;

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

	public Climber updateClimber(Climber climber, Long climberId) {
		Climber toUpdate = findClimberById(climberId);
		toUpdate.setUserName(climber.getUserName());
		toUpdate.setFirstName(climber.getFirstName());
		toUpdate.setSurName(climber.getSurName());
		return this.climberRepo.save(toUpdate);
	}

	public boolean deleteClimber(Long climberId) {
		if (!this.climberRepo.existsById(climberId)) {
			throw new ClimberNotFoundException();
		}
		this.climberRepo.deleteById(climberId);
		return this.climberRepo.existsById(climberId);
	}

	public Climber findClimberById(long climberId) {
		return this.climberRepo.findById(climberId).orElseThrow(() -> new ClimberNotFoundException());
	}

}