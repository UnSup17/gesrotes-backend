package com.unicauca.gesrotes.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record TransactionalResponseDTO<T> (boolean ok,String message,T data) {
  private static final Logger logger = LoggerFactory.getLogger(TransactionalResponseDTO.class);

  public TransactionalResponseDTO {
      if (!ok) {
          logger.error("Error en la transacción: {}", message);
      }
  }
}
