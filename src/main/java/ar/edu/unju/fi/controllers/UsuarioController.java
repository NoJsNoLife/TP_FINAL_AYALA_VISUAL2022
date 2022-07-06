/*package ar.edu.unju.fi.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.services.IUsuarioService;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	/*@Autowired
	private IEmpleadorService empleadorSer;
	
	
	private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);
	
	
	@GetMapping("/loginE")
	public ModelAndView getLoginEmpleador(Usuario usuario) {
		ModelAndView mav = new ModelAndView("iniciarSesionE");
		mav.addObject("usuario", usuario);
		return mav;
	}
	
	@GetMapping("/loginC")
	public ModelAndView getLoginCiudadano(Usuario usuario) {
		ModelAndView mav = new ModelAndView("iniciarSesionC");
		mav.addObject("usuario", usuario);
		return mav;
	}
	
	@GetMapping("/logout")
	public ModelAndView getLogoutPage() {
		ModelAndView mav = new ModelAndView("redirect:/");
		Usuario usuario = usuarioSer.findByEstado(true);
		if(usuario!=null) {
			usuario.setEstado(false);
			usuarioSer.modifyUsuario(usuario);
			LOGGER.info("Se ha cerrado sesion para el email: "+usuario.getEmail());
			return mav;
		}
		LOGGER.info("Redirigiendo al Inicio...");
		return mav;
	}
	
	//DEBERIA SER PARA EMPLEADOR Y CIUDADANO PARA COMPLETAR SUS RESPECTIVOS PERFILES
	/*@GetMapping("/perfil/completar")
	public ModelAndView getTipoEmpleador(@Validated @ModelAttribute("usuario")Usuario usuario) {
		if(usuario.getTipo()=="Empleador") {
			ModelAndView mav = new ModelAndView("tipoEmpleador");
			mav.addObject("usuario", usuario);
			return mav;
		}
		ModelAndView mav = new ModelAndView("tipoCiudadano");
		mav.addObject("usuario", usuario);
		return mav;
	}*/
	
	/*@PostMapping("/nuevo")
	public ModelAndView getNextPage(@Validated @ModelAttribute("usuario")Usuario usuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("No se cumplen las reglas de validacion");
			ModelAndView mav = new ModelAndView("nuevoUsuario");
			mav.addObject("usuario", usuario);
			return mav;
		}
		if(usuarioSer.findByEmail(usuario.getEmail()) != null) {
			ModelAndView mav = new ModelAndView("redirect:/");
			LOGGER.info("Ya existe un usuario con el Mail: "+usuario.getEmail()+" registrado");
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/indexL");
		if(usuario.getTipo().equals("Empleador")) {
			usuario.setEmpleador(new Empleador());
		}
		if(usuario.getTipo().equals("Ciudadano")) {
			usuario.setCiudadano(new Ciudadano());
		}
		LOGGER.info(usuario.getTipo());
		usuarioSer.saveUsuario(usuario);
		return mav;
	}
	
	@PostMapping("/loginE")
	public ModelAndView putSesionEIn(@Validated @ModelAttribute("usuario")Usuario usuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("No se cumplen las reglas de validacion");
			ModelAndView mav = new ModelAndView("iniciarSesion");
			mav.addObject("usuario", usuario);
			return mav;
		}
		if(usuarioSer.findByEmailAndContrasenia(usuario.getEmail(), usuario.getContrasenia()) != null) {
			ModelAndView mav = new ModelAndView("redirect:/indexL");
			mav.addObject("usuario", usuario);
			usuario.setEstado(true);
			usuarioSer.modifyUsuario(usuario);
			LOGGER.info("Se ha iniciado sesion para el email: "+usuario.getEmail());
			return mav;
		}
		ModelAndView mav = new ModelAndView("iniciarSesion");
		LOGGER.info("Error al iniciar sesion para el email: "+usuario.getEmail());
		return mav;
	}
	
	@PostMapping("/loginC")
	public ModelAndView putSesionCIn(@Validated @ModelAttribute("usuario")Usuario usuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("No se cumplen las reglas de validacion");
			ModelAndView mav = new ModelAndView("iniciarSesion");
			mav.addObject("usuario", usuario);
			return mav;
		}
		if(usuarioSer.findByEmailAndContrasenia(usuario.getEmail(), usuario.getContrasenia()) != null) {
			ModelAndView mav = new ModelAndView("redirect:/indexL");
			mav.addObject("usuario", usuario);
			usuario.setEstado(true);
			usuarioSer.modifyUsuario(usuario);
			LOGGER.info("Se ha iniciado sesion para el email: "+usuario.getEmail());
			return mav;
		}
		ModelAndView mav = new ModelAndView("iniciarSesion");
		LOGGER.info("Error al iniciar sesion para el email: "+usuario.getEmail());
		return mav;
	}*/
	/*
}*/