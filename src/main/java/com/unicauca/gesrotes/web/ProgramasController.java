package com.unicauca.gesrotes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.gesrotes.services.ProgramasService;
import com.unicauca.gesrotes.domain.Programas;

@RestController
@RequestMapping("programas")
public class ProgramasController {

  @Autowired
  private ProgramasService programasService;

  @GetMapping("/list")
  public ResponseEntity<List<Programas>> get() {
    return ResponseEntity.ok()
        .header(HttpHeaders.ACCEPT)
        .contentType(MediaType.APPLICATION_JSON)
        .body(programasService.get());
  }

}
