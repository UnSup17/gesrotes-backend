package com.unicauca.gesrotes.exceptions;

import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<?> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
    if (ex.getMessage().contains("ORA-02292")) {
      return ResponseEntity.badRequest().body(Map.of(
        "ok", false,
        "message", "Elimine primero los servicios asociados a este elemento",
        "data", null
      ));
    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
      "ok", false,
      "message", "Error de integridad referencial, ya existe un elemento igual",
      "data", null
    ));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleOtherExceptions(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
      "ok", false,
      "message", ex.getMessage(),
      "data", null
    ));
  }
}
