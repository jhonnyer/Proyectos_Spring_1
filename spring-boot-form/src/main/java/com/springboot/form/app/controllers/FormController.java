package com.springboot.form.app.controllers;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springboot.form.app.models.domain.Usuario;
import com.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	//inyectar clase usuariovalidador
	@Autowired
	private UsuarioValidador validador;
	
	@GetMapping("/form")
	public String form(Model model) {
		//crea usuario vacio para cuando se carga inicialmente en formulario 
		Usuario usuario=new Usuario();
		usuario.setNombre("Jhonnyer");
		usuario.setApellido("Galindez");
		usuario.setIdentificador("123.456.789-k");
		model.addAttribute("titulo","Prueba de Formulario");
		model.addAttribute("usuario",usuario);
		return "form";
	}
	
	//Metodo optimizado recibir parametros del formulario con mensajes de error
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		//le pasamos el usuario a validar y el error que esta en result
		validador.validate(usuario, result);
		model.addAttribute("titulo","Resultados del Formulario"); 
		
		if(result.hasErrors()) {
			return "form";
		}
		model.addAttribute("usuario",usuario);
		System.out.println(usuario.getIdentificador());
		//elimina usuario de la session despues de terminado el proceso
		status.setComplete();
		return "resultado";
	}
	
//	Metodo recibir parametros del formulario con mensaje de error 
//	@PostMapping("/form")
//	public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
//		model.addAttribute("titulo","Resultados del Formulario"); 
//		
//		if(result.hasErrors()) {
//			Map<String, String> errores=new HashMap<>();
//			//getField es una lista de errores que en este caso se le hace un foreach 
//			result.getFieldErrors().forEach(err ->{
//				errores.put(err.getField(),"El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
//			});
//			model.addAttribute("error",errores);
//			return "form";
//		}
//		model.addAttribute("usuario",usuario);
//		return "resultado";
//	}
	
	// Vista que recibe los datos del formulario 
//	@PostMapping("/form")
//	public String procesar(Model model, 
//			@RequestParam String username,
//			@RequestParam String password,
//			@RequestParam String email) {
//		
//		Usuario usuario=new Usuario();
//		usuario.setUsername(username);
//		usuario.setPassword(password);
//		usuario.setEmail(email);
//		
//		model.addAttribute("titulo","Resultados del Formulario"); 
//		model.addAttribute("usuario",usuario);
//		//model.addAttribute("username",username);
//		//model.addAttribute("password",password);
//		//model.addAttribute("email",email);
//		return "resultado";
//	}
	
	
}
