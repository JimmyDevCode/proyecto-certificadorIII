package com.cortatebien.app.config;

import java.io.Serializable;

public class JwtRequest  implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7050182160109170004L;
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
