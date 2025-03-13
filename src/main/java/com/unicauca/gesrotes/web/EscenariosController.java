package com.unicauca.gesrotes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.gesrotes.domain.Escenario;
import com.unicauca.gesrotes.services.EscenariosService;
import com.unicauca.gesrotes.util.Response;

@RestController
@RequestMapping("escenarios")
public class EscenariosController {

  @Autowired
  private EscenariosService escenariosService;

  @GetMapping("/all")
  public ResponseEntity<List<Escenario>> get() {
    return Response.buildGetResponse(HttpStatus.OK, escenariosService.getEscenarios());
  }

}
