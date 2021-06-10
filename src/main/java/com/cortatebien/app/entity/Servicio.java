package com.cortatebien.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "Servicio")
public class Servicio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4353693324696339524L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_servicio; 
	private String nombre; 
	private String descripcion; 
	private Double precio; 
	@Temporal(TemporalType.TIME)
	private Date tiempo_estimado;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_sucursal")
	private Sucursal sucursal;
	
	public Integer getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(Integer id_servicio) {
		this.id_servicio = id_servicio;
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
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getTiempo_estimado() {
		return tiempo_estimado;
	}
	public void setTiempo_estimado(Date tiempo_estimado) {
		this.tiempo_estimado = tiempo_estimado;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	
	
}
