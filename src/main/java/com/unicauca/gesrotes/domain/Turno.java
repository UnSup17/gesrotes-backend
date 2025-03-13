package com.unicauca.gesrotes.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "GESROTES", name = "Turnos")
public class Turno {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Temporal(TemporalType.DATE)
  private Date dia;
  @ManyToOne
  @JoinColumn(name = "fk_id_jornadas")
  private Jornada jornada;
  @ManyToOne
  @JoinColumn(name = "fk_id_etiquetas")
  private Etiqueta etiqueta;
  @ManyToOne
  @JoinColumn(name = "fk_id_escenarios")
  private Escenario escenario;
  @ManyToOne
  @JoinColumn(name = "fk_id_estudiantestu")
  private Estudiante estudiante;
}
