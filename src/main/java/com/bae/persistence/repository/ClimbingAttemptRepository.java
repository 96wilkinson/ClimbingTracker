package com.bae.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

import com.bae.persistence.domain.ClimbingAttempts;

@Repository
public interface ClimbingAttemptRepository extends JpaRepository<ClimbingAttempts, Long>{

    ClimbingAttempts findClimbingAttemptsById(ClimbingAttempts id);
    ClimbingAttempts findClimbingAttemptsByDay(ClimbingAttempts id);
    ClimbingAttempts findClimbingAttemptsByMonth(ClimbingAttempts id);
    ClimbingAttempts findClimbingAttemptsByYear(ClimbingAttempts id);
    ClimbingAttempts findClimbingAttemptsByDifficulty(ClimbingAttempts id);
    ClimbingAttempts findClimbingAttemptsByTimeSpent(ClimbingAttempts id);
}