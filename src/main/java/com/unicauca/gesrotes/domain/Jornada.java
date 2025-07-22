package com.unicauca.gesrotes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "GESROTES", name = "JORNADAS")
public class Jornada {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "OID")
  private Long id;

  @Column(name = "DESCRIPCION")
  private String descripcion;

  @Column(name = "HORAINICIO")
  private int horaInicio;

  @Column(name = "HORAFIN")
  private int horaFin;

  @Column(name = "ALIMENTACIONES")
  private String meals;

  @Column(name = "ACTIVA")
  private int active;

}
