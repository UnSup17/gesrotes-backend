package com.unicauca.gesrotes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(schema = "ACADEMICO", name = "ESTUDIANTES")
public class Estudiantes {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "OID")
  private Long id;

  @Column(name = "CODIGO")
  private String codigo;

  @OneToOne
  @JoinColumn(name = "TERCERO")
  private Tercero tercero;

  @ManyToOne
  @JoinColumn(name = "PROGRAMA")
  private Programas programa;
}
