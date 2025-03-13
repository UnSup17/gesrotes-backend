package com.unicauca.gesrotes.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(schema = "GESROTES", name = "ETIQUETAS")
public class Etiqueta {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etiquetas_seq")
  @SequenceGenerator(name = "etiquetas_seq", sequenceName = "GESROTES.ETIQUETAS_SEQ", allocationSize = 1)
  @Column(name = "OID")
  private Long id;

  @Column(name = "DESCRIPCION")
  private String label;

  @ManyToOne
  @JoinColumn(name = "ESCENARIO")
  @JsonBackReference
  private Escenario escenario;

}
