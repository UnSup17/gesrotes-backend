package com.unicauca.gesrotes.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(schema = "ACADEMICO", name = "PROGRAMAS")
@Getter
@Setter
@ToString
@Entity
public class Programas {
  @Id
  @Column(name = "OID")
  private Long id;

  @Column(name = "NOMBRE")
  private String nombre;

  @Column(name = "SNIESPROGRAMA")
  private String snies;

  @ManyToOne
  @JoinColumn(name = "FACULTAD")
  @JsonManagedReference
  private Facultades facultad;

  @OneToMany(mappedBy = "programa")
  @JsonBackReference
  private List<Materias> materias;

  @OneToMany(mappedBy = "programa")
  private List<Estudiantes> estudiantes;

}
