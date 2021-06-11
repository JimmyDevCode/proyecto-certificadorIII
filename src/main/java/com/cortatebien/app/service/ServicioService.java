package com.cortatebien.app.service;

import java.util.List;
import java.util.Optional;

import com.cortatebien.app.dto.ServicioDto;
import com.cortatebien.app.entity.Servicio;

public interface ServicioService {

public abstract List<Servicio> obtenerServicios();
	
	public abstract Servicio guardarServicio(ServicioDto dto);
	
	public abstract Optional<Servicio> servicioPorId (Integer id);
	
	public abstract List<Servicio> serviciosPorCategoria();
	
}
