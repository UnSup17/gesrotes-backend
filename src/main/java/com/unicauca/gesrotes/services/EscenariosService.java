package com.unicauca.gesrotes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Escenario;
import com.unicauca.gesrotes.repository.EscenariosRepository;

@Service
public class EscenariosService {

  @Autowired
  private EscenariosRepository escenariosRepository;

  public List<Escenario> getEscenarios() {
    return escenariosRepository.findAll();
  }
  
}
