package com.unicauca.gesrotes.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unicauca.gesrotes.domain.Periodo;

public interface PeriodosRepository extends CrudRepository<Periodo, Long> {

  @Query(value = "SELECT * FROM ( " +
        "    SELECT  " +
        "        p.*, " +
        "        ROW_NUMBER() OVER ( " +
        "            ORDER BY  " +
        "                CASE WHEN REGEXP_LIKE(p.DESCRIPCION, '[A-Z]') THEN 2 ELSE 1 END ASC,  " +
        "                p.OID ASC " +
        "        ) AS rn " +
        "    FROM ACADEMICO.PERIODOS p " +
        "    WHERE p.NIVELAPLICA = 'PREGRADO'  " +
        "    AND SYSDATE BETWEEN p.INICIO AND p.FIN " +
        ") WHERE rn = 1", nativeQuery = true)
  Periodo getUltimoPeriodoActivo();

}
