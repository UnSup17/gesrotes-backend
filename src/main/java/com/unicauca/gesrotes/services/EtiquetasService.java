package com.unicauca.gesrotes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.dto.NuevaEtiquetaRequestDTO;
import com.unicauca.gesrotes.dto.TransactionalResponseDTO;
import com.unicauca.gesrotes.dto.projection.EtiquetaEscenarioDTO;
import com.unicauca.gesrotes.repository.EtiquetasRepository;
import com.unicauca.gesrotes.util.Response;

@Service
public class EtiquetasService {

  @Autowired
  private EtiquetasRepository etiquetaRepository;

  public List<EtiquetaEscenarioDTO> getListaEtiquetaEscenario() {
    return etiquetaRepository.getListaEtiquetaEscenario();
  }

  public ResponseEntity<TransactionalResponseDTO<List<EtiquetaEscenarioDTO>>> crear(NuevaEtiquetaRequestDTO request) {
    try {
        int result = etiquetaRepository.crear(request.etiqueta(), request.escenario());
        if (result > 0) {
            return Response.buildResponse(HttpStatus.OK, "Ok", getListaEtiquetaEscenario());
        }
    } catch (Exception e) {
        String causa = e.getCause().toString().indexOf(".UQ_") > 0 ? "Ya existe una etiqueta con ese nombre" : e.getMessage();
        return Response.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, causa, null);
    }
    return Response.buildResponse(HttpStatus.NOT_MODIFIED, "No se logró la creación de la etiqueta", null);
}

  public ResponseEntity<TransactionalResponseDTO<List<EtiquetaEscenarioDTO>>> eliminar(Long id) {
    try {
      int result = etiquetaRepository.eliminar(id);
      if (result > 0) {
          return Response.buildResponse(HttpStatus.OK, "Ok", getListaEtiquetaEscenario());
      }
  } catch (Exception e) {
      String causa = e.getCause().toString().indexOf(".UQ_") > 0 ? "Ya existe una etiqueta con ese nombre" : e.getMessage();
      return Response.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, causa, null);
  }
  return Response.buildResponse(HttpStatus.NOT_MODIFIED, "No se logró la creación de la etiqueta", null);
  }

}
