package ar.edu.unju.fi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class PagesController {

	//private static final Log LOGGER = LogFactory.getLog(PagesController.class);
	
	@GetMapping("/")
	public String getIndexPage(Model model) {
		return "index";
	}
	
	@GetMapping("/indexL")
	public ModelAndView getAlumunosPage(Model model) {
		ModelAndView mav = new ModelAndView("indexL");
		return mav;
	}
	
}