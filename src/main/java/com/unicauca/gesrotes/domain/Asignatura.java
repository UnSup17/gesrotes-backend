package com.unicauca.gesrotes.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Asignaturas")
public class Asignatura {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_Asignaturas")
  private Long id;
  @Column(name = "codigo")
  private String codigo;
  @Column(name = "descripcion")
  private String descripcion;
  @ManyToMany(mappedBy = "asignaturas")
  private List<Estudiante> estudiantes;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_id_programasasig")
  private Programa programa;

}
