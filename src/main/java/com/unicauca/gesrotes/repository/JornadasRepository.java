package com.unicauca.gesrotes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.gesrotes.domain.Jornada;

public interface JornadasRepository extends CrudRepository<Jornada, Long> {

  @SuppressWarnings("null")
  List<Jornada> findAll();

}
