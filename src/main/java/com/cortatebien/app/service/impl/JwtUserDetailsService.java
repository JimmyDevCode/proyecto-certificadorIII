package com.cortatebien.app.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cortatebien.app.dto.UsuarioDto;
import com.cortatebien.app.entity.Rol;
import com.cortatebien.app.entity.Usuario;
import com.cortatebien.app.repository.IRolRepository;
import com.cortatebien.app.repository.IUsuarioRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Autowired
	private IUsuarioRepository userR;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired 
	private IRolRepository rolR;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Usuario user = userR.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Este email no está registrado: " + email);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				new ArrayList<>());
		
	}
	
	public Usuario save(UsuarioDto user) {
		
		Usuario newUser = new Usuario();
		newUser.setNombre(user.getNombre());
		newUser.setApellido(user.getApellido());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		Optional<Rol> rolOptional = rolR.findById(user.getId_rol());
		if(rolOptional.isPresent()) {
			newUser.setRol(rolOptional.get());
		}
		userR.save(newUser);
		return newUser;
		
		
	}
	public Usuario userContext (String email) {
		
		Usuario user = userR.findByEmail(email);
		//Object userId = user.getId_usuario();
		return user;
	}

}
