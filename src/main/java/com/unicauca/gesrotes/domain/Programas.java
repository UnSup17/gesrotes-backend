package com.unicauca.gesrotes.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "GESROTES", name = "PROGRAMAS")
public class Programas {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "OID")
  private Long id;

  @Column(name = "NOMBRE")
  private String nombre;

  @Column(name = "SNIESPROGRAMA")
  private String snies;

  @ManyToOne
  @JoinColumn(name = "FACULTAD")
  private Facultades facultad;

  @OneToMany(mappedBy = "programa")
  private List<Materias> materias;

  @OneToMany(mappedBy = "programa")
  private List<Estudiantes> estudiantes;

}
