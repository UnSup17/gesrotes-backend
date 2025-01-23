package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Escenario;
import com.unicauca.gesrotes.dto.response.EscenariosResponse;

public final class EscenariosMapper {

  private EscenariosMapper() {
    throw new IllegalStateException(Constants.UTILITY_CLASS);
  }

  public static EscenariosResponse domainToDTO(Escenario escenario) {
    EscenariosResponse escenarioResponse = new EscenariosResponse();
    escenarioResponse.setId(escenario.getId());
    escenarioResponse.setDescripcion(escenario.getNombre());
    return escenarioResponse;
  }

}