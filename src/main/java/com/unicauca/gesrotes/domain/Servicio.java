package com.unicauca.gesrotes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Servicios")
public class Servicio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_servicios")
  private Long id;
  private String descripcion;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_id_etiquetasser")
  private Etiqueta etiqueta;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_id_escenariosser")
  private Escenario escenario;

}
