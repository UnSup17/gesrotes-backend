package com.unicauca.gesrotes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.gesrotes.dto.projection.EstudianteSeleccionTurnosDTO;
import com.unicauca.gesrotes.services.EstudiantesService;
import com.unicauca.gesrotes.util.Response;

@RestController
@RequestMapping("estudiantes")
public class EstudiantesController {

  @Autowired
  private EstudiantesService estudianteService;

  @GetMapping("")
  public ResponseEntity<List<EstudianteSeleccionTurnosDTO>> get(@Param("asignatura") Long asignatura) {
    return Response.buildGetResponse(HttpStatus.OK, estudianteService.getByAsignaturaId(asignatura));
  }

}
