package com.unicauca.gesrotes.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "ACADEMICO", name = "ESTUDIANTES")
public class Estudiante {

  @Id
  @Column(name = "OID")
  private Long id;

  @Column(name = "CODIGO")
  private String codigo;

  @OneToOne
  @JoinColumn(name = "TERCERO")
  @JsonBackReference
  private Tercero tercero;

  @ManyToOne
  @JoinColumn(name = "PROGRAMA")
  @JsonBackReference
  private Programa programa;
}
