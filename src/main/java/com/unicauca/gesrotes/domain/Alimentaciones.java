package com.unicauca.gesrotes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "GESROTES", name = "ALIMENTACIONES")
public class Alimentaciones {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "OID")
  private Long id;

  // Table that contains the bits of foods assigned to each meal record
  @Column(name = "COMIDAS")
  private String comidas;

  @ManyToOne
  @JoinColumn(name = "JORNADA")
  private Jornadas jornada;
}
