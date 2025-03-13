package com.unicauca.gesrotes.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "GESROTES", name = "ESCENARIOS")
public class Escenario {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "OID")
  private Long id;

  @Column(name = "DESCRIPCION")
  private String label;

  @OneToMany(mappedBy = "escenario")
  @JsonBackReference
  private List<Servicio> servicios;

  @OneToMany(mappedBy = "escenario")
  @JsonBackReference
  private List<Etiqueta> etiquetas;

}
