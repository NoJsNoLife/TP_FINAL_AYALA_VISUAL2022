package ar.edu.unju.fi.controllers;

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
import ar.edu.unju.fi.services.ICiudadanoService;
import ar.edu.unju.fi.services.IEmpleadorService;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {
	
	/*	MEDIANTE ESTE FRAGMENTO CONTROLO LA SESION DEL USUARIO Y LO ENVIO A LAS VIEWS CORRESPONDIENTES    FUNCIONA DENTRO DE LOS METODOS GET
	 * 
	 * Empleador e = empleadorSer.findByEstado(true);
		if(e!=null) {
			ModelAndView mav = new ModelAndView("redirect:/*****");
			LOGGER.info("Redirigido a ******...");
			return mav;
		}
	 * 
	 * 
	 * 
	 *  LOS METODOS TIPO STRING SE USAN PARA VIEWS QUE NO REQUIEREN MOSTRAR INFORMACION
	 *  LOS METODOS MODELANDVIEW SE USAN PARA PAGINAS QUE REQUIERAN UN FLUJO DE INFORMACION DEL USUARIO
	 *  
	 *  
	 *  FALTA AGREGAR VALIDACION SI EXISTE UN USUARIO ESTADO TRUE DE TIPO CIUDADANO PARA QUE NO ENTRE A ESTAS PAGINAS. EL CIUDADANO SOLO ENTRA A SUS PAGINAS, NO A LAS DE TIPO EMPLEADOR
	 */
	
	@Autowired
	private IEmpleadorService empleadorSer;
	
	@Autowired
	private ICiudadanoService ciudadanoSer;
	
	
	private static final Log LOGGER = LogFactory.getLog(EmpleadorController.class);
	
	@GetMapping("/nuevo")
	public String getNuevoUsuario(Model model) {
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c!=null) {
			LOGGER.info("Redirigido a Inicio...");
			return "redirect:/indexC";
		}
		Empleador e = empleadorSer.findByEstado(true);
		if(e!=null) {
			LOGGER.info("Redirigido a Inicio...");
			return "redirect:/indexE";
		}
		model.addAttribute("empleador", empleadorSer.getEmpleador());
		return "nuevoE";
	}
	
	@GetMapping("/perfil")
	public ModelAndView getPerfil() {
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexC");
			mav.addObject("ciudadano", c);
			LOGGER.info("Redirigido a Iniciar Sesion...");
			return mav;
		}
		Empleador e = empleadorSer.findByEstado(true);
		if(e!=null) {
				ModelAndView mav = new ModelAndView("perfilEmpleador");
				mav.addObject("empleador", e);
				LOGGER.info("Se ha accedido al perfil del empleador con CUIT: "+e.getCuit());
				return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/empleador/login");
		LOGGER.info("Redirigido a Iniciar Sesion...");
		return mav;
	}
	
	@GetMapping("/perfil/editar")
	public ModelAndView getEditarPerfil() {
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexC");
			mav.addObject("ciudadano", c);
			LOGGER.info("Redirigido a Iniciar Sesion...");
			return mav;
		}
		Empleador e = empleadorSer.findByEstado(true);
		if(e!=null) {
			ModelAndView mav = new ModelAndView("editarE");
			mav.addObject("empleador", e);
			LOGGER.info("Entrando a edición de perfil del usuario con CUIT: "+e.getCuit());
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/empleador/login");
		LOGGER.info("Redirigido a Iniciar Sesion...");
		return mav;
	}
	
	@GetMapping("/login")
	public ModelAndView getLoginEmpleador(Empleador empleador) {
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexC");
			mav.addObject("ciudadano", c);
			LOGGER.info("Redirigido a Iniciar Sesion...");
			return mav;
		}
		Empleador e = empleadorSer.findByEstado(true);
		if(e!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexE");
			mav.addObject(e);
			LOGGER.info("Redirigido a Inicio...");
			return mav;
		}
		ModelAndView mav = new ModelAndView("iniciarSesionE");
		mav.addObject("empleador", empleador);
		return mav;
	}
	
	@GetMapping("/logout")
	public ModelAndView getLogoutPage() {
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexC");
			mav.addObject("ciudadano", c);
			LOGGER.info("Redirigido a Iniciar Sesion...");
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/");
		Empleador e = empleadorSer.findByEstado(true);
		if(e!=null) {
			empleadorSer.setSesionOut(e);
			return mav;
		}
		LOGGER.info("Redirigiendo al Inicio...");
		return mav;
	}
	
	@PostMapping("/nuevo")
	public ModelAndView getNextPage(@Validated @ModelAttribute("empleador")Empleador empleador, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("No se cumplen las reglas de validacion");
			ModelAndView mav = new ModelAndView("nuevoE");
			mav.addObject("empleador", empleador);
			return mav;
		}
		if(empleadorSer.findByCuit(empleador.getCuit()) != null) {
			ModelAndView mav = new ModelAndView("redirect:/");
			LOGGER.info("Ya existe un usuario con el CUIT: "+empleador.getCuit()+" registrado");
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/indexE");
		empleadorSer.saveEmpleador(empleador);
		return mav;
	}
	
	@PostMapping("/perfil/editar")
	public ModelAndView getEditarPerfil( @ModelAttribute("empleador")Empleador empleador, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("No se cumplen las reglas de validacion");
			ModelAndView mav = new ModelAndView("editarE");
			mav.addObject("empleador", empleador);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/empleador/perfil");
		empleadorSer.modifyPerfilE(empleador);
		mav.addObject("empleador", empleador);
		return mav;
	}
	
	@PostMapping("/login")
	public ModelAndView putSesionEIn(@Validated @ModelAttribute("empleador")Empleador empleador, BindingResult bindingResult) {
		Empleador e = empleadorSer.findByCuitAndContrasenia(empleador.getCuit(), empleador.getContrasenia());
		if(e!= null) {
			ModelAndView mav = new ModelAndView("redirect:/indexE");
			mav.addObject("empleador", e);
			empleadorSer.setSesionIn(e);
			return mav;
		}
		if(bindingResult.hasErrors()) {
			LOGGER.info("No se cumplen las reglas de validacion");
			ModelAndView mav = new ModelAndView("iniciarSesionE");
			mav.addObject("empleador", empleador);
			return mav;
		}	
		ModelAndView mav = new ModelAndView("iniciarSesionE");
		LOGGER.info("Error al iniciar sesion para el CUIT: "+empleador.getCuit());
		return mav;
	}

}
