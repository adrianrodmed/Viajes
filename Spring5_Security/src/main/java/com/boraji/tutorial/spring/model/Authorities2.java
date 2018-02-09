package com.boraji.tutorial.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Authorities2 {
  @Id
  @Column(name = "idusuarios")
  private String idusuarios;

  @ManyToOne
  @JoinColumn(name = "nombre")
  private User nombre;

  public String getIdusuarios() {
    return idusuarios;
  }

  public void setIdusuarios(String idusuarios) {
    this.idusuarios = idusuarios;
  }

  public User getNombre() {
    return nombre;
  }

  public void setNombre(User nombre) {
    this.nombre = nombre;
  }

}
