package com.unicauca.gesrotes.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "ACADEMICO", name = "TERCEROS")
public class Tercero {

  @Id
  @Column(name = "OID")
  private Integer id;
  private String identificacion;
  private String primernombre;
  private String segundonombre;
  private String primerapellido;
  private String segundoapellido;
  private String telefono;
  private String email;
  private String direccion;
  private String genero;
  @Temporal(TemporalType.DATE)
  private Date nacimiento;

  @ManyToOne
  @JoinColumn(name = "RH")
  @JsonManagedReference
  private FactorRH factorRh;

  @OneToOne(mappedBy = "tercero")
  @JsonManagedReference
  private Estudiante estudiante;

}
