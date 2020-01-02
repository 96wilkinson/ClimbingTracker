package com.bae.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.persistence.repository.ClimberRepository;
import com.bae.persistence.domain.Climber;

import exceptions.ClimberNotFoundException;

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

	public Climber updateClimber(Climber climber, Long id) {
		Climber toUpdate = findClimberById(id);
		toUpdate.setUserName(climber.getUserName());
		toUpdate.setFirstName(climber.getFirstName());
		toUpdate.setSurName(climber.getSurName());
		return this.climberRepo.save(toUpdate);
	}

	public boolean deleteClimber(Long id) {
		if (!this.climberRepo.existsById(id)) {
			throw new ClimberNotFoundException();
		}
		this.climberRepo.deleteById(id);
		return this.climberRepo.existsById(id);
	}

	public Climber findClimberById(Long id) {
		return this.climberRepo.findById(id).orElseThrow(() -> new ClimberNotFoundException());
	}

}