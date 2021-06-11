package com.cortatebien.app.dto;



public class ServicioDto {

	private String nombre;  
	private String descripcion; 
	private Double precio; 
	private Integer id_sucursal; 
	private Integer id_categoria;
	
	
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
	public Integer getId_sucursal() {
		return id_sucursal;
	}
	public void setId_sucursal(Integer id_sucursal) {
		this.id_sucursal = id_sucursal;
	}
	public Integer getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	
}
