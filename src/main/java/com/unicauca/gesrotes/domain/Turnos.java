package com.unicauca.gesrotes.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "GESROTES", name = "Turnos")
public class Turnos {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Temporal(TemporalType.DATE)
  private Date dia;
  @ManyToOne
  @JoinColumn(name = "fk_id_jornadas")
  private Jornadas jornada;
  @ManyToOne
  @JoinColumn(name = "fk_id_etiquetas")
  private Etiquetas etiqueta;
  @ManyToOne
  @JoinColumn(name = "fk_id_escenarios")
  private Escenarios escenario;
  @ManyToOne
  @JoinColumn(name = "fk_id_estudiantestu")
  private Estudiantes estudiante;
}
