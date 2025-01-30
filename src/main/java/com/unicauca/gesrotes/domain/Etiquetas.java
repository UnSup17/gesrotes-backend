package com.unicauca.gesrotes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "GESROTES", name = "ETIQUETAS")
public class Etiquetas {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "OID")
  private Long id;

  @Column(name = "DESCRIPCION")
  private String descripcion;

  @ManyToOne
  @JoinColumn(name = "ESCENARIO")
  private Escenarios escenario;

  @ManyToOne
  @JoinColumn(name = "SERVICIO")
  private Servicios servicio;
}
