package com.unicauca.gesrotes.services;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.sql.Clob;
import java.sql.Types;

@Service
public class OracleJsonService {

  @NonNull
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public Clob getMatrizEstudianteSemana(Long grupoClase, String desde, String hasta) {
    SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
        .withSchemaName("GESROTES")
        .withCatalogName("PKG_TURNOS")
        .withFunctionName("MATRIZESTUDIANTESSEMANA")
        .declareParameters(
            new SqlOutParameter("v_json", Types.CLOB),
            new SqlParameter("P_GRUPO", Types.INTEGER),
            new SqlParameter("P_INICIO", Types.VARCHAR),
            new SqlParameter("P_FIN", Types.VARCHAR))
        .withoutProcedureColumnMetaDataAccess();
    SqlParameterSource paramMap = new MapSqlParameterSource()
        .addValue("P_GRUPO", grupoClase)
        .addValue("P_INICIO", desde)
        .addValue("P_FIN", hasta);
    return call.executeFunction(Clob.class, paramMap);
  }
}
