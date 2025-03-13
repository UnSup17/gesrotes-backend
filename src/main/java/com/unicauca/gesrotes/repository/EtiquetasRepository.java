package com.unicauca.gesrotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unicauca.gesrotes.domain.Etiqueta;
import com.unicauca.gesrotes.dto.projection.EtiquetaEscenarioDTO;

import jakarta.transaction.Transactional;

public interface EtiquetasRepository extends CrudRepository<Etiqueta, Long> {

  @Query(value = "SELECT DISTINCT E.OID ID, E.DESCRIPCION ETIQUETA, e2.oid IDESCENARIO, E2.DESCRIPCION ESCENARIO " +
        "FROM GESROTES.ETIQUETAS E " +
        "JOIN GESROTES.ESCENARIOS E2 ON E.ESCENARIO = E2.OID " +
        "ORDER BY E.OID DESC", nativeQuery = true)
  List<EtiquetaEscenarioDTO> getListaEtiquetaEscenario();

  @Transactional
  @Modifying
  @Query(value = "INSERT INTO GESROTES.ETIQUETAS (DESCRIPCION, ESCENARIO) VALUES (?1, ?2)", nativeQuery = true)
  int crear(String etiqueta, Long escenario);

  @Transactional
  @Modifying
  @Query(value = "DELETE FROM GESROTES.ETIQUETAS E WHERE E.OID = ?1", nativeQuery = true)
  int eliminar(Long id);

}
