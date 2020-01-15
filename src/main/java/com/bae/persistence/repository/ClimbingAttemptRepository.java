package com.bae.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import com.bae.persistence.domain.ClimbingAttempts;

@Repository
public interface ClimbingAttemptRepository extends JpaRepository<ClimbingAttempts, Long> {

    Set<ClimbingAttempts> findClimbingAttemptsById(Long id);

    Set<ClimbingAttempts> findClimbingAttemptsByDay(int day);

    Set<ClimbingAttempts> findClimbingAttemptsByMonth(int month);

    Set<ClimbingAttempts> findClimbingAttemptsByYear(int year);

    Set<ClimbingAttempts> findClimbingAttemptsByDifficulty(int difficulty);

    Set<ClimbingAttempts> findClimbingAttemptsByTimeSpent(int timeSpent);
}