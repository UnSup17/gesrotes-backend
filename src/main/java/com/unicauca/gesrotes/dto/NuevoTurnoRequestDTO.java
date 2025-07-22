package com.unicauca.gesrotes.dto;

import java.time.LocalDate;

public record NuevoTurnoRequestDTO(LocalDate dia, Long jornada, Long etiqueta, Long estudiante, Long grupo) {
  
}
