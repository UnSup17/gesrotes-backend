package com.unicauca.gesrotes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Jornada;
import com.unicauca.gesrotes.repository.JornadasRepository;

@Service
public class JornadasService {

  @Autowired
  private JornadasRepository jornadasRepository;

  public List<Jornada> getJornadas() {
    return jornadasRepository.findAll();
  }
  
}
