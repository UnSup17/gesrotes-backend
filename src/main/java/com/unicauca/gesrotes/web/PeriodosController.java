package com.unicauca.gesrotes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.gesrotes.domain.Periodo;
import com.unicauca.gesrotes.services.PeriodosService;
import com.unicauca.gesrotes.util.Response;

@RestController
@RequestMapping("periodos")
public class PeriodosController {

  @Autowired
  private PeriodosService periodoService;

  @GetMapping("/activo")
  public ResponseEntity<Periodo> getUltimoPeriodo() {
    return Response.buildGetResponse(HttpStatus.OK, periodoService.getUltimoPeriodo());
  }

}
