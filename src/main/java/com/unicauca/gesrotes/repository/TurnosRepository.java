package com.unicauca.gesrotes.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unicauca.gesrotes.domain.Turno;
import com.unicauca.gesrotes.dto.projection.TurnoGrupoDiaDTO;

import jakarta.transaction.Transactional;

public interface TurnosRepository extends CrudRepository<Turno, Long> {

  @Transactional
  @Modifying
  @Query(value = "INSERT INTO GESROTES.TURNOS (DIA,JORNADA,ETIQUETA,ESTUDIANTE,GRUPO) VALUES (?1,?2, ?3, ?4, ?5)", nativeQuery = true)
  int crear(LocalDate date, Long jornada, Long etiqueta, Long estudiante, Long grupo);

  @Transactional
  @Modifying
  @Query(value = "DELETE FROM GESROTES.TURNOS T WHERE T.OID = ?1", nativeQuery = true)
  int eliminar(Long id);

  @Query(value = """
      SELECT
          te.PRIMERNOMBRE || ' ' || te.SEGUNDONOMBRE || ' ' || te.PRIMERAPELLIDO || ' ' || te.SEGUNDOAPELLIDO estudiante,
          es.DESCRIPCION escenario,
          e.DESCRIPCION as etiqueta,
          LPAD(TRUNC(J.HORAINICIO / 60), 2, '0') || ':' ||
          LPAD(MOD(J.HORAINICIO, 60), 2, '0') || ' - ' ||
          LPAD(TRUNC(J.HORAFIN / 60), 2, '0') || ':' ||
          LPAD(MOD(J.HORAFIN, 60), 2, '0') horario,
          j.DESCRIPCION as jornada,
          j.ALIMENTACIONES,
          t.ESTUDIANTE idEstudiante,
          t.OID idTurno
      FROM GESROTES.TURNOS t
      JOIN GESROTES.JORNADAS j ON t.JORNADA = j.OID
      JOIN GESROTES.ETIQUETAS e ON t.ETIQUETA = e.OID
      JOIN GESROTES.ESCENARIOS es ON es.OID = j.ESCENARIO --AND es.OID = e.ESCENARIO
      JOIN ACADEMICO.ESTUDIANTES s ON t.ESTUDIANTE = s.OID
      JOIN ACADEMICO.TERCEROS te ON te.OID = s.TERCERO
      WHERE t.DIA = ?1 AND t.GRUPO = ?2 AND t.ESTUDIANTE = ?3
      """, nativeQuery = true)
  List<TurnoGrupoDiaDTO> findByDayAndGroupAndStudent(LocalDate dia, Long grupo, Long estudiante);
}