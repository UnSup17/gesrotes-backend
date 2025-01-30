package com.unicauca.gesrotes.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
public class AppController {

  @GetMapping("/get")
  public ResponseEntity<String> get() {
    return ResponseEntity.ok()
        .header(HttpHeaders.ACCEPT)
        .contentType(MediaType.APPLICATION_JSON)
        .body("Hello World");
  }

}
