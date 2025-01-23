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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Jornadas")
public class Jornada {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_jornadas")
  private Long id;
  private String descripcion;
  @Temporal(TemporalType.TIME)
  @Column(name = "horainicio")
  private Date horaInicio;
  @Temporal(TemporalType.TIME)
  @Column(name = "horafin")
  private Date horaFin;
  @Column
  private Double duracion;
  @Column
  private Date vigencia;

  @OneToMany(mappedBy = "jornada")
  private List<Alimentacion> alimentaciones;
}
