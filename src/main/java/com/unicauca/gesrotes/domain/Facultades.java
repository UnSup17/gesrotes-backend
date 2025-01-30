package com.unicauca.gesrotes.domain;

import java.util.List;

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
@Table(schema = "GESROTES", name = "FACULTADES")
public class Facultades {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "OID")
  private Long id;

  @Column(name = "NOMBRE")
  private String nombre;

  @Column(name = "UBICACION")
  private String ubicacion;

  @OneToMany(mappedBy = "facultad")
  private List<Programas> programas;

}
