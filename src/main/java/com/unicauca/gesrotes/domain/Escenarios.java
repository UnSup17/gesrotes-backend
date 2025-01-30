package com.unicauca.gesrotes.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
