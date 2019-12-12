package com.BAE.Persistence.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BAE.Persistence.domain.Climbers;

@Repository
public interface ClimberRepository extends JpaRepository<Climbers, Long> {

}