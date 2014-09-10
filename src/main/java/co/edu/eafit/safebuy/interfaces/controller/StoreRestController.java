package co.edu.eafit.safebuy.interfaces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import co.edu.eafit.safebuy.domain.model.comprador.Store;
import co.edu.eafit.safebuy.infraestructure.persistence.util.PersistenceService;

@Controller
public class StoreRestController {
	
	@Autowired
	private PersistenceService persistenceService;
	
	@RequestMapping("/store.html")
	public ModelAndView getPage(){
		return new ModelAndView("/pages/indexstore.jsp");
	}
	
	@RequestMapping(value = "/rest/store", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Store> getStoreList() {
		return persistenceService.executeQuery(Store.class, "SELECT s FROM Store s");
	}
	
	@RequestMapping(value = "/rest/store/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Store getStore(@PathVariable("id") int id) {
		return persistenceService.findById(Store.class, id);
	}
	
	@RequestMapping(value = "/rest/store", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Store createStore(@RequestBody Store store) {
		return persistenceService.save(store);
	}
	
	@RequestMapping(value = "/rest/store/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Store updateStore(@RequestBody Store store, @PathVariable("id") int id) {
		return persistenceService.update(store);
	}
	
	@RequestMapping(value = "/rest/store/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteStore(@PathVariable("id") int id) {
		persistenceService.remove(persistenceService.findById(Store.class, id));
	}

}
