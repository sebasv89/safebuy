package co.edu.eafit.safebuy.interfaces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.edu.eafit.safebuy.infraestructure.persistence.util.PersistenceService;

@Controller
public class StoreRestController {
	
	@Autowired
	private PersistenceService persistenceService;
	
	@RequestMapping("/store.html")
	public ModelAndView getPage(){
		return new ModelAndView("indexstore.html");
	}

}
