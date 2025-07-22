package com.unicauca.gesrotes.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Servicio;
import com.unicauca.gesrotes.dto.ServicioDTO;
import com.unicauca.gesrotes.repository.ServiciosRepository;

@Service
public class ServiciosService {

  @Autowired
  private ServiciosRepository serviciosRepository;

  public List<Servicio> getByEscenario(Long escenario) {
    return serviciosRepository.getByEscenarioId(escenario);
  }

  public Map<Long, List<ServicioDTO>> getServiciosAgrupadosPorEscenario() {
    List<ServicioDTO> servicios = serviciosRepository.getAll();
    return servicios.stream().collect(Collectors.groupingBy(ServicioDTO::escenario));
  }

}
