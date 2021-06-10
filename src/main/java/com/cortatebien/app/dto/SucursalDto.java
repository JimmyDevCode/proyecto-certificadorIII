package com.cortatebien.app.dto;


public class SucursalDto {

	private Integer id_sucursal;
	private String razon_social;
	private Integer ruc;
	private String nombre; 
	private String telefono; 
	private String direccion;
	private Integer id_usuario;
	private Integer id_distrito;
	public Integer getId_sucursal() {
		return id_sucursal;
	}
	public void setId_sucursal(Integer id_sucursal) {
		this.id_sucursal = id_sucursal;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public Integer getRuc() {
		return ruc;
	}
	public void setRuc(Integer ruc) {
		this.ruc = ruc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Integer getId_distrito() {
		return id_distrito;
	}
	public void setId_distrito(Integer id_distrito) {
		this.id_distrito = id_distrito;
	}
	
	
	
}
