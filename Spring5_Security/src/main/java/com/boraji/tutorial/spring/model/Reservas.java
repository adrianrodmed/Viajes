package com.boraji.tutorial.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reservas {
  @Id
  @Column(name = "idReserva")
  private int idReserva;

  @Column(name = "idUsuario")
  private int idUsuario;
  
  @Column(name = "idDestino")
  private int idDestino;
  
  @Column(name = "nunPlazas")
  private int numPlazas;
  
  @Column(name = "precioTotal")
  private float precioTotal;

	public int getIdReserva() {
		return idReserva;
	}
	
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public int getIdDestino() {
		return idDestino;
	}
	
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}
	
	public int getNumPlazas() {
		return numPlazas;
	}
	
	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}
	
	public float getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
}
