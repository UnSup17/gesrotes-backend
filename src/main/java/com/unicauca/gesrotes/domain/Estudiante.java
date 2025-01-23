package com.unicauca.gesrotes.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Estudiantes")
public class Estudiante {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_estudiantes")
  private Long id;
  private String codigo;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_id_personasest")
  private Persona persona;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_id_programasest")
  private Programa programa;
}
