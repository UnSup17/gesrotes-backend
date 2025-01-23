package com.unicauca.gesrotes.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "Turnos")
public class Turno {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Temporal(TemporalType.DATE)
  private Date dia;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_id_jornadas")
  private Jornada jornada;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_id_etiquetas")
  private Etiqueta etiqueta;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_id_escenarios")
  private Escenario escenario;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_id_estudiantestu")
  private Estudiante estudiante;
}
