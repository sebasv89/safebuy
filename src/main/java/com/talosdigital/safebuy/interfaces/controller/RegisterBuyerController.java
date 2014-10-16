package com.talosdigital.safebuy.interfaces.controller;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.talosdigital.safebuy.controllers.BuyerController;
import com.talosdigital.safebuy.domain.model.Buyer;
import com.talosdigital.safebuy.persistence.util.PersistenceService;
import com.talosdigital.safebuy.util.MessageType;
import com.talosdigital.safebuy.util.ResponseMessage;
import com.talosdigital.safebuy.util.dto.BuyerDto;

@Controller
public class RegisterBuyerController {

	@Autowired
	private PersistenceService persistenceService;

	@Autowired
	private BuyerController buyerController;
	
	@RequestMapping("/registerBuyer.html")
	public ModelAndView getPage() {
		return new ModelAndView("/pages/registerBuyer.jsp");
	}

	@RequestMapping("/registerBuyerAction.html")
	public ModelAndView submitForm(
			@RequestParam String user,
			@RequestParam String name,
			@RequestParam String lastName,
			@RequestParam String birthDay,
			@RequestParam String email,
			@RequestParam(required = false, defaultValue = "false") Boolean receiveNotification)
			throws ParseException {
		if (StringUtils.isEmpty(user)) {
			return ResponseMessage.createMessage(
					"El Nombre de usuario no puede estar vacio",
					MessageType.error);
		}
		if (StringUtils.isEmpty(name)) {
			return ResponseMessage.createMessage(
					"El Nombre no puede estar vacio", MessageType.error);
		}
		if (StringUtils.isEmpty(lastName)) {
			return ResponseMessage.createMessage(
					"El Apellido no puede estar vacio", MessageType.error);
		}
		if (StringUtils.isEmpty(birthDay)) {
			return ResponseMessage.createMessage(
					"El cumpleanos no puede estar vacio", MessageType.error);
		}
		if (StringUtils.isEmpty(email)) {
			return ResponseMessage.createMessage(
					"El Email no puede estar vacio", MessageType.error);
		}
		BuyerDto buyerdto = new BuyerDto();
		buyerdto.setName(name.toLowerCase());
		buyerdto.setLastName(lastName.toLowerCase());
		
		List<Buyer> existingBuyersWithId = buyerController.existingBuyerWithId(name);
		
		if (CollectionUtils.isNotEmpty(existingBuyersWithId)) {
			return ResponseMessage.createMessage(
					"El usuario comprador ya existe: " + user,
					MessageType.error);
		}
		buyerController.createSafeBuyer(buyerdto);
		return ResponseMessage.createMessage("Comprador Creado",
				MessageType.success);
	}
}
