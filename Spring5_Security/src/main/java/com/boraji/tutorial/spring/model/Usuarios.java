package com.boraji.tutorial.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {
  @Id
  @Column(name = "idUsuario")
  private String idUsuario;

  @Column(name = "mail")
  private String mail;
  
  @Column(name = "pass")
  private String pass;
  
  @Column(name = "nombre")
  private String nombre;
  
  @Column(name = "telf")
  private String telf;

  
	public String getIdusuario() {
		return idusuario;
	}
	
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTelf() {
		return telf;
	}
	
	public void setTelf(String telf) {
		this.telf = telf;
	}
}
