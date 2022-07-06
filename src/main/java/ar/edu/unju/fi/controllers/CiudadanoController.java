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
import ar.edu.unju.fi.entity.Cv;
import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.services.ICiudadanoService;
import ar.edu.unju.fi.services.ICvService;
import ar.edu.unju.fi.services.IEmpleadorService;

@Controller
@RequestMapping("/ciudadano")
public class CiudadanoController {
	
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
	private ICiudadanoService ciudadanoSer;
	
	@Autowired
	private IEmpleadorService empleadorSer;
	
	@Autowired
	private ICvService cvSer;
	
	
	private static final Log LOGGER = LogFactory.getLog(CiudadanoController.class);
	
	@GetMapping("/nuevo")
	public String getNuevoUsuario(Model model) {
		Empleador e = empleadorSer.findByEstado(true);
		if(e!=null) {
			LOGGER.info("Redirigido a Inicio...");
			return "redirect:/indexE";
		}
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c!=null) {
			LOGGER.info("Redirigido a Inicio...");
			return "redirect:/indexC";
		}
		model.addAttribute("ciudadano", ciudadanoSer.getCiudadano());
		return "nuevoC";
	}
	
	@GetMapping("/perfil")
	public ModelAndView getPerfil() {
		Empleador e = empleadorSer.findByEstado(true);
		if(e!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexE");
			mav.addObject("empleador", e);
			LOGGER.info("Redirigido a Iniciar Sesion...");
			return mav;
		}
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c!=null) {
				ModelAndView mav = new ModelAndView("perfilCiudadano");
				mav.addObject("ciudadano", c);
				LOGGER.info("Se ha accedido al perfil del ciudadano con DNI: "+c.getDni());
				return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/login");
		LOGGER.info("Redirigido a Iniciar Sesion...");
		return mav;
	}
	
	@GetMapping("/perfil/editar")
	public ModelAndView getEditarPerfil() {
		Empleador e = empleadorSer.findByEstado(true);
		if(e!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexE");
			mav.addObject("empleador", e);
			LOGGER.info("Redirigido a Iniciar Sesion...");
			return mav;
		}
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c!=null) {
			ModelAndView mav = new ModelAndView("editarC");
			mav.addObject("ciudadano", c);
			LOGGER.info("Entrando a edición de perfil del ciudadano con DNI: "+c.getDni());
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/login");
		LOGGER.info("Redirigido a Iniciar Sesion...");
		return mav;
	}
	
	@GetMapping("/perfil/cv")
	public ModelAndView getVerCv() {
		Empleador e = empleadorSer.findByEstado(true);
		if(e!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexE");
			mav.addObject("empleador", e);
			LOGGER.info("Redirigido a Iniciar Sesion...");
			return mav;
		}
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c!=null) {
			ModelAndView mav = new ModelAndView("verCv");
			mav.addObject("ciudadano", c);
			mav.addObject("cv", c.getCv());
			LOGGER.info("Entrando al de cv del ciudadano con DNI: "+c.getDni());
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/login");
		LOGGER.info("Redirigido a Iniciar Sesion...");
		return mav;
	}
	
	@GetMapping("/perfil/cv/editar")
	public ModelAndView getEditarCv() {
		Empleador e = empleadorSer.findByEstado(true);
		if(e!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexE");
			mav.addObject("empleador", e);
			LOGGER.info("Redirigido a Iniciar Sesion...");
			return mav;
		}
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c!=null) {
			ModelAndView mav = new ModelAndView("editarCv");
			mav.addObject("cv", c.getCv());
			LOGGER.info("Entrando a edición de Cv del ciudadano con DNI: "+c.getDni());
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/login");
		LOGGER.info("Redirigido a Iniciar Sesion...");
		return mav;
	}
	
	@GetMapping("/login")
	public ModelAndView getLoginEmpleador(Ciudadano ciudadano) {
		Empleador e = empleadorSer.findByEstado(true);
		if(e!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexE");
			mav.addObject("empleador", e);
			LOGGER.info("Redirigido a Iniciar Sesion...");
			return mav;
		}
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexC");
			mav.addObject(c);
			LOGGER.info("Redirigido a Inicio...");
			return mav;
		}
		ModelAndView mav = new ModelAndView("iniciarSesionC");
		mav.addObject("ciudadano", ciudadano);
		return mav;
	}
	
	@GetMapping("/logout")
	public ModelAndView getLogoutPage() {
		Empleador e = empleadorSer.findByEstado(true);
		if(e!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexE");
			mav.addObject("empleador", e);
			LOGGER.info("Redirigido a Iniciar Sesion...");
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/");
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c!=null) {
			ciudadanoSer.setSesionOut(c);
			return mav;
		}
		LOGGER.info("Redirigiendo al Inicio...");
		return mav;
	}
	
	@PostMapping("/nuevo")
	public ModelAndView getNextPage(@Validated @ModelAttribute("ciudadano")Ciudadano ciudadano, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("No se cumplen las reglas de validacion");
			ModelAndView mav = new ModelAndView("nuevoC");
			mav.addObject("ciudadano", ciudadano);
			return mav;
		}
		if(ciudadanoSer.findByDni(ciudadano.getDni()) != null) {
			ModelAndView mav = new ModelAndView("redirect:/");
			LOGGER.info("Ya existe un usuario con el DNI: "+ciudadano.getDni()+" registrado");
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/indexC");
		Cv cv = cvSer.getCv();
		cvSer.saveCv(cv);
		ciudadano.setCv(cv);
		ciudadanoSer.saveCiudadano(ciudadano);
		return mav;
	}
	
	@PostMapping("/perfil/editar")
	public ModelAndView getEditarPerfil( @ModelAttribute("ciudadano")Ciudadano ciudadano, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("No se cumplen las reglas de validacion");
			ModelAndView mav = new ModelAndView("editarC");
			mav.addObject("ciudadano", ciudadano);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/perfil");
		ciudadanoSer.modifyPerfilC(ciudadano);
		mav.addObject("ciudadano", ciudadano);
		return mav;
	}
	
	@PostMapping("/perfil/cv/editar")
	public ModelAndView getEditarCv( @ModelAttribute("ciudadano")Cv cv, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("No se cumplen las reglas de validacion");
			ModelAndView mav = new ModelAndView("editarC");
			mav.addObject("cv", cv);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/perfil/cv");
		cvSer.modifyCv(cv);
		mav.addObject("cv", cv);
		return mav;
	}
	
	@PostMapping("/login")
	public ModelAndView putSesionEIn(@Validated @ModelAttribute("ciudadano")Ciudadano ciudadano, BindingResult bindingResult) {
		Ciudadano c = ciudadanoSer.findByDniAndContrasenia(ciudadano.getDni(), ciudadano.getContrasenia());
		if(c!= null) {
			ModelAndView mav = new ModelAndView("redirect:/indexC");
			mav.addObject("ciudadano", c);
			ciudadanoSer.setSesionIn(c);
			return mav;
		}
		if(bindingResult.hasErrors()) {
			LOGGER.info(bindingResult.getAllErrors());
			LOGGER.info("No se cumplen las reglas de validacion");
			ModelAndView mav = new ModelAndView("iniciarSesionC");
			mav.addObject("ciudadano", ciudadano);
			return mav;
		}	
		ModelAndView mav = new ModelAndView("iniciarSesionC");
		LOGGER.info("Error al iniciar sesion para el DNI: "+ciudadano.getDni());
		return mav;
	}
}
