package com.unicauca.gesrotes.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(schema = "ACADEMICO", name = "FACULTADES")
@Getter
@Setter
@ToString
@Entity
public class Facultad {

  @Id
  @Column(name = "OID")
  private Long id;

  @Column(name = "NOMBRE")
  private String nombre;

  @OneToMany(mappedBy = "facultad")
  @JsonBackReference
  private List<Programa> programas;

}
