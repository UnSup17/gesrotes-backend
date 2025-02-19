package com.unicauca.gesrotes.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
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
public class Escenarios {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "OID")
  private Long id;

  @Column(name = "NOMBRE")
  private String nombre;

  @Column(name = "DIRECCION")
  private String direccion;

  @OneToMany(mappedBy = "escenario", cascade = CascadeType.ALL)
  private List<Servicios> servicios;

  @OneToMany(mappedBy = "escenario", cascade = CascadeType.ALL)
  private List<Etiquetas> etiquetas;

}
