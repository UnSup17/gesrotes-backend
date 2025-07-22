package com.unicauca.gesrotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unicauca.gesrotes.domain.Servicio;
import com.unicauca.gesrotes.dto.ServicioDTO;

public interface ServiciosRepository extends CrudRepository<Servicio, Long> {

  List<Servicio> getByEscenarioId(Long escenario);

  @Query("SELECT new com.unicauca.gesrotes.dto.ServicioDTO(s.id, s.label, s.escenario.id) FROM Servicio s")
  List<ServicioDTO> getAll();

}
