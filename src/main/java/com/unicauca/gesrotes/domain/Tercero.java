package com.unicauca.gesrotes.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "ACADEMICO", name = "TERCEROS")
public class Tercero {

  @Id
  private Long identificacion;
  private String nombre;
  private String apellido;
  private String telefono;
  private String correo;
  private String direccion;
  private String genero;
  @Temporal(TemporalType.DATE)
  private Date fechaNacimiento;
  private String clave;
  @Column(name = "tiposangre")
  private String tipoSangre;
  @Column(name = "lugarnacimiento")
  private String lugarNacimiento;
  @OneToOne(mappedBy = "tercero")
  private Estudiantes estudiante;

}
