package com.springboot.form.app.models.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Usuario {
	//No se valida, es unico del usuario en este caso 
	//Validacion con patterns permite validar los campos en el formulario su estructura 
	//Ejemplo: dos numeros de 0 a 9; seguido de un punto. Tres numeros de 0 a 9 y asi sucesivamente
	//  \\d significa que se repite la primer opcion de [0-9] en este caso y se repite 3 veces
	//@Pattern permite validar cualquier tipo de dato y caracteres de forma personalizada
	//Comente pattern porque se va a validar con una clase validation en lugar de pattern
	//	@Pattern(regexp="[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	private String identificador;
//	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotEmpty()
	@Size(min=3,max=8, message="El login de usuario debe estar entre 3 y 8 caracteres")
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	@Email(message="El formato del correo electronico no es valido, debe contener un @.")
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	
}
