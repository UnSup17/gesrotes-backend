package com.unicauca.gesrotes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
