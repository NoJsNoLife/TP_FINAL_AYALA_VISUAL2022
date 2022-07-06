package ar.edu.unju.fi.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.services.ICiudadanoService;
import ar.edu.unju.fi.services.IEmpleadorService;


@Controller
@RequestMapping("/")
public class PagesController {
	
	@Autowired
	private IEmpleadorService empleadorSer;
	
	@Autowired
	private ICiudadanoService ciudadanoSer;

	private static final Log LOGGER = LogFactory.getLog(PagesController.class);
	
	@GetMapping("/")
	public String getIndexPage(Model model) {
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
		return "index";
	}
	
	@GetMapping("/indexE")
	public ModelAndView getEmpleadorPage(Model model) {
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexC");
			LOGGER.info("Redirigido a Inicio...");
			return mav;
		}
		Empleador e = empleadorSer.findByEstado(true);
		if(e==null) {
			ModelAndView mav = new ModelAndView("redirect:/");
			LOGGER.info("Redirigido a Inicio...");
			return mav;
		}
		ModelAndView mav = new ModelAndView("indexE");
		return mav;
	}
	
	@GetMapping("/indexC")
	public ModelAndView getCiudadanoPage(Model model) {
		Empleador e = empleadorSer.findByEstado(true);
		if(e!=null) {
			ModelAndView mav = new ModelAndView("redirect:/indexE");
			LOGGER.info("Redirigido a Inicio...");
			return mav;
		}
		Ciudadano c = ciudadanoSer.findByEstado(true);
		if(c==null) {
			ModelAndView mav = new ModelAndView("redirect:/");
			LOGGER.info("Redirigido a Inicio...");
			return mav;
		}
		ModelAndView mav = new ModelAndView("indexC");
		return mav;
	}
	
}