package com.unicauca.gesrotes.web;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.gesrotes.dto.NuevoTurnoRequestDTO;
import com.unicauca.gesrotes.dto.TransactionalResponseDTO;
import com.unicauca.gesrotes.services.TurnosService;
import com.unicauca.gesrotes.util.Response;

@RestController
@RequestMapping("turnos")
public class TurnosController {

  @Autowired
  private TurnosService turnosService;

  @GetMapping("")
  public ResponseEntity<Object> getMatrizEstudianteSemana(@Param("grupoClase") Long grupoClase,
      @Param("desde") String desde, @Param("hasta") String hasta) {
    try {
      Object aux = turnosService.getMatrizEstudianteSemana(grupoClase, desde, hasta).toMap();
      return Response.buildGetResponse(HttpStatus.OK,aux);
    } catch (Exception e) {
      return Response.buildGetResponse(HttpStatus.INTERNAL_SERVER_ERROR, new JSONObject());
    }
  }

  @PostMapping("nuevo")
  public ResponseEntity<TransactionalResponseDTO<Object>> nuevo(@RequestBody NuevoTurnoRequestDTO request) {
    return turnosService.crear(request);
  }

  @DeleteMapping("{id}/eliminar")
  public ResponseEntity<TransactionalResponseDTO<Boolean>> eliminarEtiqueta(@PathVariable Long id) {
    return turnosService.eliminar(id);
  }

}
