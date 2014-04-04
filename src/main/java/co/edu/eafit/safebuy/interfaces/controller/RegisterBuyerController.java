package co.edu.eafit.safebuy.interfaces.controller;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.edu.eafit.safebuy.util.ResponseMessage;
import co.edu.eafit.safebuy.util.MessageType;

@Controller
public class RegisterBuyerController {

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
		return ResponseMessage.createMessage("Buyer created.",
				MessageType.success);
	}
}
