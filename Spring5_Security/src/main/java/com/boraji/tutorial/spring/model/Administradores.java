package com.boraji.tutorial.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "administradores")
public class Administradores {
  @Id
  @Column(name = "pass")
  private String pass;

  @ManyToOne
  @JoinColumn(name = "mail")
  private User mail;

	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public User getMail() {
		return mail;
	}
	
	public void setMail(User mail) {
		this.mail = mail;
	}
}
