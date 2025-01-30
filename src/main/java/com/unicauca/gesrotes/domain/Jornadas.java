package com.unicauca.gesrotes.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "GESROTES", name = "JORNADAS")
public class Jornadas {

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
  private List<Alimentaciones> alimentaciones;

}
