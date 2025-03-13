package com.unicauca.gesrotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.unicauca.gesrotes.domain.Estudiante;
import com.unicauca.gesrotes.dto.projection.EstudianteSeleccionTurnosDTO;

public interface EstudiantesRepository extends CrudRepository<Estudiante, Long> {

  @Query(value = "SELECT e.oid id, g2.SELECCIONGESROTES isSelected, " +
        "t.PRIMERNOMBRE || ' ' || t.SEGUNDONOMBRE || ' ' || t.PRIMERAPELLIDO || ' ' || t.SEGUNDOAPELLIDO fullName  " +
        "FROM GRUPOSCLASE g  " +
        "JOIN GRUPOSESTUDIANTES g2 ON g.oid = g2.GRUPO " +
        "JOIN ESTUDIANTES e ON e.oid = g2.ESTUDIANTE  " +
        "JOIN TERCEROS t ON t.oid = e.TERCERO  " +
        "WHERE g.MATERIA = :asignaturaId AND g.PERIODO = :periodoId " +
        "ORDER BY g.PERIODO DESC", nativeQuery = true)
  List<EstudianteSeleccionTurnosDTO> getMenuByPrograma(@Param("asignaturaId") Long asignaturaId, @Param("periodoId") Long periodoId);

}
