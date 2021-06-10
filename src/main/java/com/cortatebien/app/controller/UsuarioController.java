package com.cortatebien.app.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cortatebien.app.config.JwtRequest;
import com.cortatebien.app.config.JwtResponse;
import com.cortatebien.app.config.JwtTokenUtil;
import com.cortatebien.app.dto.UsuarioDto;
import com.cortatebien.app.entity.Usuario;
import com.cortatebien.app.service.UsuarioService;
import com.cortatebien.app.service.impl.JwtUserDetailsService;


@RestController
@RequestMapping("/apiUser")
//@CrossOrigin(origins = "http://127.0.0.1:5500/", methods= {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UsuarioDto user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	
	private void authenticate(String email, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@RequestMapping(value= "/listar", method = RequestMethod.GET)
	public ArrayList<Usuario> obtenerUsuarios(){
		return (ArrayList<Usuario>) usuarioService.obtenerUsuarios();
	}
	
	@GetMapping("/hola")
	public Usuario hola() {
		
		Object uP= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (uP instanceof UserDetails) {
			  userDetails = (UserDetails) uP;
			}
		
		//Es el metodo para obtener el usuario
		String userName = userDetails.getUsername();
		Usuario user = userDetailsService.userContext(userName);
		//Object id = user.getId_usuario();
		
		return user;
		
	}
	
	
	/*@GetMapping("/listar")
	public ArrayList<Usuario> obtenerUsuarios(){
		return (ArrayList<Usuario>) usuarioService.obtenerUsuarios();
	}

	@PostMapping("/register")
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody UsuarioDto dto) {
		return new ResponseEntity<Usuario>(usuarioService.guardarUsuario(dto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Optional<Usuario> usuarioPorId(@PathVariable("id") Integer id){
		return usuarioService.usuarioPorId(id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> loginUsuario(@RequestBody UsuarioDto dto){
		
		 return new ResponseEntity<Usuario>(usuarioService.loginUsuario(dto), HttpStatus.OK);
	}*/
}
