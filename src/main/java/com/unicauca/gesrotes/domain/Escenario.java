package com.unicauca.gesrotes.domain;

import java.util.ArrayList;
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
@Table(name = "Escenarios")
public class Escenario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_escenarios")
  private Long id;
  private String nombre;
  private String direccion;
  @OneToMany(mappedBy = "escenario", cascade = CascadeType.ALL)
  private List<Servicio> servicios;
  @OneToMany(mappedBy = "escenario", cascade = CascadeType.ALL)
  private List<Etiqueta> etiquetas;

  public void agregarServicio(Servicio servicio) {
    if (this.servicios == null) {
      this.servicios = new ArrayList<>();
    }
    this.servicios.add(servicio);
  }

  public void agregarEtiqueta(Etiqueta etiqueta) {
    if (this.etiquetas == null) {
      this.etiquetas = new ArrayList<>();
    }
    this.etiquetas.add(etiqueta);
  }
}
