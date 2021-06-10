package com.cortatebien.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "distrito")
public class Distrito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9088828921529039619L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_distrito; 
	private String nombre;
	
	public Integer getId_distrito() {
		return id_distrito;
	}
	public void setId_distrito(Integer id_distrito) {
		this.id_distrito = id_distrito;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
