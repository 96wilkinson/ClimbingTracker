package com.bae.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.Persistence.domain.ClimbingAttempts;

@Repository
public interface ClimbingAttemptRepository extends JpaRepository<ClimbingAttempts, Long>{

}