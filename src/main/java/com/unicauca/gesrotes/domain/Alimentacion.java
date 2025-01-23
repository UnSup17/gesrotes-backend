package com.unicauca.gesrotes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Alimentacion")
public class Alimentacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "OID")
  private Long id;

  // Table that contains the bits of foods assigned to each meal record
  @Column
  private String comidas;

  @ManyToOne
  @JoinColumn(name = "jornada")
  private Jornada jornada;
}
