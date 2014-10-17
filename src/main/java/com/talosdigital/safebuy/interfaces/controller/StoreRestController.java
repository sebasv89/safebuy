package com.talosdigital.safebuy.interfaces.controller;

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

import com.talosdigital.safebuy.domain.model.Store;
import com.talosdigital.safebuy.persistence.dao.StoreDao;
import com.talosdigital.safebuy.util.dto.StoreDto;

@Controller
public class StoreRestController {

	@Autowired
	private StoreDao storedao;
	
	@RequestMapping("/store.html")
	public ModelAndView getPage(){
		return new ModelAndView("/pages/indexstore.jsp");
	}
	
	@RequestMapping(value = "/rest/store", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Store> getStoreList() {
		return storedao.getStoreList();
	}
	
	@RequestMapping(value = "/rest/store/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Store getStore(@PathVariable("id") int id) {
		return storedao.getStore(id);
	}
	
	@RequestMapping(value = "/rest/store", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Store createStore(@RequestBody StoreDto storedto) {
		return storedao.createStore(storedto.fromDto(storedto));
	}
	
	@RequestMapping(value = "/rest/store/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Store updateStore(@RequestBody StoreDto storedto, @PathVariable("id") int id) {
		storedto.setId(id);
		Store store = storedao.updateStore(storedto.fromDto(storedto));
		return store;
	}
	
	@RequestMapping(value = "/rest/store/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteStore(@PathVariable("id") int id) {
		storedao.deleteStore(id);
	}

}
