package com.unicauca.gesrotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.unicauca.gesrotes.domain.Periodo;
import com.unicauca.gesrotes.repository.PeriodosRepository;

@ApplicationScope
@Service
public class PeriodosService {

  Periodo ultimoPeriodo;

  @Autowired
  private PeriodosRepository periodoRepository;

  public Periodo getUltimoPeriodo() {
    if (ultimoPeriodo == null) {
      ultimoPeriodo = periodoRepository.getUltimoPeriodoActivo();
    }
    return ultimoPeriodo;
  }
  
}
