package com.unicauca.gesrotes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unicauca.gesrotes.repository.ProgramasRepository;
import com.unicauca.gesrotes.domain.Programas;

@Service
public class ProgramasService {

  @Autowired
  private ProgramasRepository programasRepository;

  public List<Programas> get() {
    return (List<Programas>) programasRepository.findAll();
  }
}
