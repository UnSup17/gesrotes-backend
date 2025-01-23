package com.unicauca.gesrotes.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ContactosProgramas")
public class ContactoPrograma {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String telefono;
  private String correo;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_id_programas")
  private Programa programa;
}
