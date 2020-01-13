package com.bae.persistence.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.Climber;


@Repository
public interface ClimberRepository extends JpaRepository<Climber, Long> {

	List<Climber> findByUsername(String username);
    List<Climber> findByFirstname(String firstname);
    List<Climber> findBySurname(String surname);
}