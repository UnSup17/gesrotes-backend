package com.unicauca.gesrotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.gesrotes.domain.Escenario;

@Repository
public interface EscenarioRepository extends JpaRepository<Escenario, Long> {
}
