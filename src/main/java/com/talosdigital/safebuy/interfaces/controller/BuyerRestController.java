package com.talosdigital.safebuy.interfaces.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import com.talosdigital.safebuy.controllers.BuyerController;
import com.talosdigital.safebuy.domain.model.Buyer;
import com.talosdigital.safebuy.util.dto.BuyerDto;

@Controller
public class BuyerRestController {
	
	@Autowired
	private BuyerController buyerController;
	
	@RequestMapping("/hola.html")
	public ModelAndView getPage() {
		return new ModelAndView("/pages/index.jsp");
	}

	@RequestMapping(value = "/rest/buyer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Buyer> getSafeBuyerList() {
		//response.setHeader("Content-type", MediaType.APPLICATION_JSON.toString());
		return buyerController.getSafeBuyerList();
	}
	
	@RequestMapping(value = "/rest/buyer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Buyer getSafeBuyer(HttpServletResponse response, @PathVariable("id") int id) {
		//response.setHeader("Content-type", MediaType.APPLICATION_JSON.toString());
		return buyerController.getSafeBuyer(id);
	}

	@RequestMapping(value = "/rest/buyer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Buyer createSafeBuyer(@RequestBody BuyerDto buyerdto) {
		return buyerController.createSafeBuyer(buyerdto);
	}

	@RequestMapping(value = "/rest/buyer/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void updateSafeBuyer(@RequestBody BuyerDto buyer, @PathVariable("id") int id) {
		buyerController.updateSafeBuyer(buyer);
	}

	@RequestMapping(value = "/rest/buyer/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteSafeBuyer(@PathVariable("id") int id) {
		buyerController.deleteSafeBuyer(id);
	}
}
