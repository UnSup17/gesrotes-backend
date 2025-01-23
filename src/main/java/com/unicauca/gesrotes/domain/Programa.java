package com.unicauca.gesrotes.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "Programas")
public class Programa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_programas")
  private Long id;
  private String codigosnies;
  private String nombre;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_id_facultades")
  private Facultad facultad;
  @OneToMany(mappedBy = "programa", cascade = CascadeType.ALL)
  private List<ContactoPrograma> contactoProgramas;
  @OneToMany(mappedBy = "programa", cascade = CascadeType.ALL)
  private List<Asignatura> asignaturas;

  @OneToMany(mappedBy = "programa", cascade = CascadeType.ALL)
  private List<Estudiante> estudiantes;

  public void agregarContactoProgama(ContactoPrograma contactoPrograma) {
    if (this.contactoProgramas == null) {
      this.contactoProgramas = new ArrayList<>();
    }
    this.contactoProgramas.add(contactoPrograma);
  }

  public void agregarAsignatura(Asignatura asignatura) {
    if (this.asignaturas == null) {
      this.asignaturas = new ArrayList<>();
    }
    this.asignaturas.add(asignatura);
  }

  public void agregarEstudiante(Estudiante estudiante) {
    if (this.estudiantes == null) {
      this.estudiantes = new ArrayList<>();
    }
    this.estudiantes.add(estudiante);
  }
}
