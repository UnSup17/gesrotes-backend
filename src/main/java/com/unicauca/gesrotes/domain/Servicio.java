package com.unicauca.gesrotes.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "GESROTES", name = "SERVICIOS")
public class Servicio {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "OID")
  private Long id;

  @Column(name = "DESCRIPCION")
  private String label;

  @ManyToOne
  @JoinColumn(name = "ESCENARIO")
  @JsonBackReference
  private Escenario escenario;

}
