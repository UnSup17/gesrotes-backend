package com.unicauca.gesrotes.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.unicauca.gesrotes.dto.TransactionalResponseDTO;

public class Response {
  public static <T> ResponseEntity<TransactionalResponseDTO<T>> buildResponse(HttpStatus status, String message, T data) {
    return ResponseEntity.status(status)
        .header(HttpHeaders.ACCEPT)
        .contentType(MediaType.APPLICATION_JSON)
        .body(new TransactionalResponseDTO<>(status.is2xxSuccessful(), message, data));
  }

  public static <T> ResponseEntity<T> buildGetResponse(HttpStatus status, T body) {
    return ResponseEntity.status(status)
    .header(HttpHeaders.ACCEPT)
    .contentType(MediaType.APPLICATION_JSON)
    .body(body);
  }
}
