package com.unicauca.gesrotes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.gesrotes.dto.projection.AsignaturaMenuDTO;
import com.unicauca.gesrotes.services.AsignaturasService;
import com.unicauca.gesrotes.util.Response;

@RestController
@RequestMapping("asignaturas")
public class AsignaturasController {

  @Autowired
  private AsignaturasService asignaturaService;

  @GetMapping("")
  public ResponseEntity<List<AsignaturaMenuDTO>> get(@Param("programa") Long programa) {
    return Response.buildGetResponse(HttpStatus.OK, asignaturaService.getByProgramaId(programa));
  }

}
