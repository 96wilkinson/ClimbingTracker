package com.BAE.Persistence.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BAE.Persistence.domain.Climber;

@Repository
public interface ClimberRepository extends JpaRepository<Climber, Long> {

}