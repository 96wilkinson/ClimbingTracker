package com.bae.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.bae.persistence.domain.ClimbingAttempts;

@Repository
public interface ClimbingAttemptRepository extends JpaRepository<ClimbingAttempts, Long>{

    List<ClimbingAttempts> findClimbingAttemptsById(ClimbingAttempts test_attempt);
}