package com.cortatebien.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "dia")
public class Dia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3273651738165282006L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_dia; 
	private String nombre;
	public Integer getId_dia() {
		return id_dia;
	}
	public void setId_dia(Integer id_dia) {
		this.id_dia = id_dia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
