package com.bae.persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.Climbers;

@Repository
public interface ClimberRepository extends JpaRepository<Climbers, Long> {

}