package com.springboot.form.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springboot.form.app.models.domain.Usuario;

//Clase para validar campos de un formulario de forma personalizasa sin pattern. Comentar validacion pattern
//Componente para que se pueda inyectar en el controlador
@Component 
public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		//se  coloca para valdiar si la clase usuario corresponde al usuario. 
		//Se coloca que clase se va a validar, en este caso Usuario. 
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Recibimos el objeto, en este caso tipo Usuario. Se puede validar los campos
		Usuario usuario=(Usuario)target;
		ValidationUtils.rejectIfEmpty(errors, "nombre", "NotEmpty.usuario.nombre");
		
		//Opcional, funciona igual que el anterior
//		if(usuario.getNombre().isEmpty()) {
//			errors.rejectValue("nombre", "NotEmpty.usuario.nombre");
//		}
		//matches evalua coincidencia, en este caso si evalua esa coincidencia de la expresion indicada
//		if(usuario.getIdentificador().matches("[0-9]{2}[.][\\\\d]{3}[.][\\\\d]{3}[-][A-Z]{1}")==false) {
//			errors.rejectValue("identificador", "pattern.usuario.identificador");
//		}
		
		//Similar a la expresion anterior, pero se niega con el simbolo !
		if(!usuario.getIdentificador().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")) {
			errors.rejectValue("identificador", "pattern.usuario.identificador");
		}
	}

}
