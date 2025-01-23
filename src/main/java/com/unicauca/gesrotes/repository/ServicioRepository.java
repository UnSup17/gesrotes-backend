package com.unicauca.gesrotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.gesrotes.domain.Escenario;
import com.unicauca.gesrotes.domain.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
  List<Servicio> findByEscenario(Escenario escenario);
}
