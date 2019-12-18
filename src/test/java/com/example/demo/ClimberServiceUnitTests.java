package com.example.demo;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.BAE.Bussiness.ClimberService;
import com.BAE.Persistence.Repository.ClimberRepository;
import com.BAE.Persistence.domain.Climber;

@SpringBootTest
public class ClimberServiceUnitTests {

	@Mock
	private ClimberRepository repo;
	
	@InjectMocks 
	private ClimberService service;


	@Test
	public void getAllClimbersTest() {	//service is fine its just we have no repostiory as we have no DB
		List<Climber> climberRepo = new ArrayList<>();
		climberRepo.add(new Climber("ClimberDude123", "John", "Smith"));
		Mockito  // follows the given when testing
			.when(repo.findAll()) //when repo.find all is called return ->
			.thenReturn(new ArrayList<Climber>()); // <- this
		assertTrue("Returned when no Climbers", this.service.getAllClimber().size() > 0);

		Mockito.verify(repo, times(1)).findAll(); //verifying the repo.findall has 
							// to be called at least once
	}
}
