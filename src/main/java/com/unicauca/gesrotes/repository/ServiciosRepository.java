package com.unicauca.gesrotes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.gesrotes.domain.Servicio;

public interface ServiciosRepository extends CrudRepository<Servicio, Long> {

  List<Servicio> getByEscenarioId(Long escenario);

}
