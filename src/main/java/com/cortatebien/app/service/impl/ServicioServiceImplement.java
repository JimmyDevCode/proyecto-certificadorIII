package com.cortatebien.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cortatebien.app.dto.ServicioDto;
import com.cortatebien.app.entity.Categoria;
import com.cortatebien.app.entity.Servicio;
import com.cortatebien.app.entity.Sucursal;
import com.cortatebien.app.repository.ICategoriaRepository;
import com.cortatebien.app.repository.IServicioRepository;
import com.cortatebien.app.repository.ISucursalRepository;
import com.cortatebien.app.service.ServicioService;

@Service
public class ServicioServiceImplement implements ServicioService{

	@Autowired
	IServicioRepository iservicioRepository;

	@Autowired
	ICategoriaRepository icategoriaRepository;
	
	@Autowired
	ISucursalRepository isucursalRepository;
	
	@Override
	public List<Servicio> obtenerServicios() {
		// TODO Auto-generated method stub
		return iservicioRepository.findAll();
	}

	@Override
	public Servicio guardarServicio(ServicioDto dto) {
		
		Servicio servicio = new Servicio();
		servicio.setNombre(dto.getNombre());
		servicio.setDescripcion(dto.getDescripcion());
		servicio.setPrecio(dto.getPrecio());
		Optional<Categoria> categoria = icategoriaRepository.findById(dto.getId_categoria());
		if(categoria.isPresent()) {
			servicio.setCategoria(categoria.get());
		}
		Optional<Sucursal> sucursal = isucursalRepository.findById(dto.getId_sucursal());
		if(sucursal.isPresent()) {
			servicio.setSucursal(sucursal.get());
		}
		iservicioRepository.save(servicio);
		return servicio;
	}

	@Override
	public Optional<Servicio> servicioPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Servicio> serviciosPorCategoria() {
		// TODO Auto-generated method stub
		return null;
	}
}