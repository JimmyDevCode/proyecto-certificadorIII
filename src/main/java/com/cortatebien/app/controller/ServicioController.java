package com.cortatebien.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cortatebien.app.dto.ServicioDto;
import com.cortatebien.app.entity.Servicio;
import com.cortatebien.app.service.impl.ServicioServiceImplement;

@RestController
@RequestMapping("/apiServicio")
public class ServicioController {

	@Autowired
	ServicioServiceImplement servicioService;
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody ServicioDto servicio) throws Exception {
		return ResponseEntity.ok(servicioService.guardarServicio(servicio));
	}
	
	@GetMapping("/listar")
	public ArrayList<Servicio> obtenerServicios(){
		return (ArrayList<Servicio>) servicioService.obtenerServicios();
	}
}
