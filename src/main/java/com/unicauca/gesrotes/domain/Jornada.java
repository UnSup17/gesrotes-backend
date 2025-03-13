package com.unicauca.gesrotes.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
  private Date horaInicio;

  @Column(name = "HORAFIN")
  private Date horaFin;

  @Column(name = "DURACION")
  private int duracion;

  @Column(name = "VIGENCIA")
  private Date vigencia;

  @OneToMany(mappedBy = "jornada")
  private List<Alimentacion> alimentaciones;

}
