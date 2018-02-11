package com.boraji.tutorial.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "destinos")
public class Destinos {
  @Id
  @Column(name = "idDestino")
  private String idDestino;

  @Column(name = "nombre")
  private String nombre;
  
  @Column(name = "descripcion")
  private String descripcion;
  
  @Column(name = "descripcionCorta")
  private String descripcionCorta;
  
  @Column(name = "precio")
  private float precio;
  
  @Column(name = "categoria")
  private String categoria;
  
  @Column(name = "plazas")
  private int plazas;
  
  @Column(name = "fecha")
  private String fecha;
  
  @Column(name = "foto")
  private String foto;

  
	public String getIdDestino() {
		return idDestino;
	}
	
	public void setIdDestino(String idDestino) {
		this.idDestino = idDestino;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcionCorta() {
		return descripcionCorta;
	}
	
	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getPlazas() {
		return plazas;
	}
	
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
}
