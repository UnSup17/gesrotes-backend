package com.unicauca.gesrotes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.gesrotes.domain.Jornada;
import com.unicauca.gesrotes.services.JornadasService;
import com.unicauca.gesrotes.util.Response;

@RestController
@RequestMapping("jornadas")
public class JornadasController {

  @Autowired
  private JornadasService JornadasService;

  @GetMapping("/all")
  public ResponseEntity<List<Jornada>> get() {
    return Response.buildGetResponse(HttpStatus.OK, JornadasService.getJornadas());
  }

}
