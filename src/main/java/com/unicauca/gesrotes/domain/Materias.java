package com.unicauca.gesrotes.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "ACADEMICO", name = "MATERIAS")
public class Materias {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "OID")
  private Long id;

  @Column(name = "CODIGO")
  private String codigo;

  @Column(name = "DESCRIPCION")
  private String descripcion;

  @ManyToOne
  @JoinColumn(name = "PROGRAMA")
  @JsonManagedReference
  private Programas programa;

}
