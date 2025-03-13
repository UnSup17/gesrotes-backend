package com.unicauca.gesrotes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.gesrotes.domain.Servicio;
import com.unicauca.gesrotes.services.ServiciosService;
import com.unicauca.gesrotes.util.Response;

@RestController
@RequestMapping("servicios")
public class ServiciosController {

  @Autowired
  private ServiciosService servicioService;

  @GetMapping("")
  public ResponseEntity<List<Servicio>> get(@Param("escenario") Long escenario) {
    return Response.buildGetResponse(HttpStatus.OK, servicioService.getByEscenario(escenario));
  }

}
