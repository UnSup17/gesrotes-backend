package com.unicauca.gesrotes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.gesrotes.domain.Escenario;

public interface EscenariosRepository extends CrudRepository<Escenario, Long> {

  List<Escenario> findAll();

}
