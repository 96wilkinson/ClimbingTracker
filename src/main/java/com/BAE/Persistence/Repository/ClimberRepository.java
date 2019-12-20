package com.bae.Persistence.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.Persistence.domain.Climber;


@Repository
public interface ClimberRepository extends JpaRepository<Climber, Long> {

	List<Climber> findByUserName(String userName);

	
}