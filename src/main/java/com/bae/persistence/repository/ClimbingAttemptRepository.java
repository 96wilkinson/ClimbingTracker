package com.bae.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.bae.persistence.domain.ClimbingAttempts;

@Repository
public interface ClimbingAttemptRepository extends JpaRepository<ClimbingAttempts, Long>{

    List<ClimbingAttempts> findClimbingAttemptsById(ClimbingAttempts id);
    List<ClimbingAttempts> findClimbingAttemptsByDay(ClimbingAttempts id);
    List<ClimbingAttempts> findClimbingAttemptsByMonth(ClimbingAttempts id);
    List<ClimbingAttempts> findClimbingAttemptsByYear(ClimbingAttempts id);
    List<ClimbingAttempts> findClimbingAttemptsByDifficulty(ClimbingAttempts id);
    List<ClimbingAttempts> findClimbingAttemptsByTimeSpent(ClimbingAttempts id);
}