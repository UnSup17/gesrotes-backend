package com.unicauca.gesrotes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Periodo;
import com.unicauca.gesrotes.dto.projection.AsignaturaMenuDTO;
import com.unicauca.gesrotes.repository.AsignaturasRepository;

@Service
public class AsignaturasService {

  @Autowired
  private AsignaturasRepository asignaturaRepository;

  @Autowired
  private PeriodosService periodoService;
  
  public List<AsignaturaMenuDTO> getByProgramaId(Long programId) {
    Periodo periodo = periodoService.getUltimoPeriodo();
    return asignaturaRepository.getMenuByPrograma(programId, periodo.getId());
  }
  
}
