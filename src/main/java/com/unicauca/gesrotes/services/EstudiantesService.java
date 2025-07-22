package com.unicauca.gesrotes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Periodo;
import com.unicauca.gesrotes.dto.projection.EstudianteSeleccionTurnosDTO;
import com.unicauca.gesrotes.repository.EstudiantesRepository;

@Service
public class EstudiantesService {

  @Autowired
  private EstudiantesRepository estudianteRepository;

  @Autowired
  private PeriodosService periodoService;

  public List<EstudianteSeleccionTurnosDTO> getByGrupoId(Long grupoId) {
    Periodo periodo = periodoService.getUltimoPeriodo();
    return estudianteRepository.getMenuByGrupo(grupoId, periodo.getId());
  }
  
}
