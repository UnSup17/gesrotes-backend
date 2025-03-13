package com.unicauca.gesrotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.dto.projection.AsignaturaMenuDTO;

public interface AsignaturasRepository extends CrudRepository<Asignatura, Long> {

  @Query(value = "SELECT g.oid id, m.DESCRIPCION || ' (' || g.SECCION || ')' label FROM GRUPOSCLASE g " +
        "JOIN MATERIAS m ON g.MATERIA = m.oid " +
        "WHERE g.PROGRAMA = :programaId AND g.PERIODO = :periodoId " +
        "ORDER BY m.DESCRIPCION, g.SECCION", nativeQuery = true)
  List<AsignaturaMenuDTO> getMenuByPrograma(@Param("programaId") Long programaId, @Param("periodoId") Long periodoId);

}
