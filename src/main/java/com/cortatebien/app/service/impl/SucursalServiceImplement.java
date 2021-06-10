package com.cortatebien.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.cortatebien.app.dto.SucursalDto;
import com.cortatebien.app.entity.Distrito;
import com.cortatebien.app.entity.Sucursal;
import com.cortatebien.app.entity.Usuario;
import com.cortatebien.app.repository.IDistritoRepository;
import com.cortatebien.app.repository.ISucursalRepository;
import com.cortatebien.app.repository.IUsuarioRepository;
import com.cortatebien.app.service.SucursalService;

@Service
public class SucursalServiceImplement implements SucursalService{

	@Autowired
	IUsuarioRepository iusuarioRepository;
	
	@Autowired
	ISucursalRepository isucursalRepository;
	
	@Autowired
	IDistritoRepository idistritoRepository;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	
	@Override
	public Sucursal guardarSucursal(SucursalDto dto) {
		Sucursal sucursal = new Sucursal();
		sucursal.setNombre(dto.getNombre());
		sucursal.setRazon_social(dto.getRazon_social());
		sucursal.setRuc(dto.getRuc());
		sucursal.setTelefono(dto.getTelefono());
		sucursal.setDireccion(dto.getDireccion());
		//Obtengo el usuario del contexto
		
		Integer id = dto.getId_usuario();
		id = idCliente();
		//
		Optional<Usuario> usuarioOptional = iusuarioRepository.findById(id);
		if(usuarioOptional.isPresent()) {
			sucursal.setUsuario(usuarioOptional.get());
		}
		Optional<Distrito> distritoOptional =idistritoRepository.findById(dto.getId_distrito());
		if(usuarioOptional.isPresent()) {
			sucursal.setDistrito(distritoOptional.get());
		}
		//sucursal.setDireccion(dto.getDireccion());
		isucursalRepository.save(sucursal);
		return sucursal;
		
	}

	@Override
	public Optional<Sucursal> sucursalPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sucursal> obtenerSucursales() {
		
		return isucursalRepository.findAll();
	}

	public Integer idCliente() {
		Object uP= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (uP instanceof UserDetails) {
			  userDetails = (UserDetails) uP;
			}
		
		//Es el metodo para obtener el usuario
		String userName = userDetails.getUsername();
		Usuario user = userDetailsService.userContext(userName);
		//Object id = user.getId_usuario();
		
		return user.getId_usuario();
	}
}
