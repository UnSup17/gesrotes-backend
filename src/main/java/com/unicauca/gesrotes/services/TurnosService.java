package com.unicauca.gesrotes.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Turno;
import com.unicauca.gesrotes.dto.NuevoTurnoRequestDTO;
import com.unicauca.gesrotes.dto.TransactionalResponseDTO;
import com.unicauca.gesrotes.repository.TurnosRepository;
import com.unicauca.gesrotes.util.Response;
import java.util.Optional;

@Service
public class TurnosService {

  @Autowired
  private TurnosRepository turnosRepository;

  @Autowired
  private OracleJsonService oracleJsonService;

  public JSONObject getMatrizEstudianteSemana(Long grupoClase, String desde, String hasta)
      throws SQLException, IOException {
    Clob clobData = oracleJsonService.getMatrizEstudianteSemana(grupoClase, desde, hasta);
    StringBuilder sb = new StringBuilder();
    try (Reader reader = clobData.getCharacterStream();
        BufferedReader br = new BufferedReader(reader)) {
      String line;
      while ((line = br.readLine()) != null) {
        sb.append(line);
      }
    }
    String newStr = sb.toString()
        .replace("&", "")
        .replace(";", "")
        .replace("quot", "\"")
        .replace("amp", "");
    return new JSONObject(newStr);
  }

  public ResponseEntity<TransactionalResponseDTO<Object>> crear(NuevoTurnoRequestDTO request) {
    try {
      int result = turnosRepository.crear(request.dia(), request.jornada(), request.etiqueta(), request.estudiante(),
          request.grupo());
      if (result > 0) {
        return Response.buildResponse(HttpStatus.OK, "Ok",
            turnosRepository.findByDayAndGroupAndStudent(request.dia(), request.grupo(), request.estudiante()));
      }
    } catch (Exception e) {
      String causa = e.getCause() != null && e.getCause().toString().contains(".UQ_") ? "Ya existe este turno"
          : e.getMessage();
      return Response.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, causa, null);
    }
    return Response.buildResponse(HttpStatus.NOT_MODIFIED, "No se logró la creación del turno", null);
  }

  public ResponseEntity<TransactionalResponseDTO<Boolean>> eliminar(Long id) {
    try {
      Optional<Turno> turno = turnosRepository.findById(id);

      if (turno.isPresent()) {
        int result = turnosRepository.eliminar(id);
        if (result > 0) {
          return Response.buildResponse(HttpStatus.OK, "Ok", true);
        }
      } else {
        return Response.buildResponse(HttpStatus.NOT_FOUND, "Turno no encontrado", null);
      }
    } catch (Exception e) {
      return Response.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
    }
    return Response.buildResponse(HttpStatus.NOT_MODIFIED, "No se logró eliminar el turno", null);
  }
}
