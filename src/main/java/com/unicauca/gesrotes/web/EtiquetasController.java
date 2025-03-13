package com.unicauca.gesrotes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.gesrotes.dto.NuevaEtiquetaRequestDTO;
import com.unicauca.gesrotes.dto.TransactionalResponseDTO;
import com.unicauca.gesrotes.dto.projection.EtiquetaEscenarioDTO;
import com.unicauca.gesrotes.services.EtiquetasService;

@RestController
@RequestMapping("etiquetas")
public class EtiquetasController {

  @Autowired
  private EtiquetasService etiquetaService;

  @GetMapping("/all")
  public ResponseEntity<List<EtiquetaEscenarioDTO>> get() {
    return ResponseEntity.ok()
        .header(HttpHeaders.ACCEPT)
        .contentType(MediaType.APPLICATION_JSON)
        .body(etiquetaService.getListaEtiquetaEscenario());
  }

  @PostMapping("nueva")
  public ResponseEntity<TransactionalResponseDTO<List<EtiquetaEscenarioDTO>>> nuevaEtiqueta(@RequestBody NuevaEtiquetaRequestDTO request) {
    return etiquetaService.crear(request);
  }

  @DeleteMapping("{id}/eliminar")
  public ResponseEntity<TransactionalResponseDTO<List<EtiquetaEscenarioDTO>>> eliminarEtiqueta(@PathVariable Long id) {
    return etiquetaService.eliminar(id);
  }
}
