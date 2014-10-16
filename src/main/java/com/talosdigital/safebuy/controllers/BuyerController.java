package com.talosdigital.safebuy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.talosdigital.safebuy.domain.model.Buyer;
import com.talosdigital.safebuy.infraestructure.persistence.dao.BuyerDao;
import com.talosdigitlal.safebuy.util.dto.BuyerDto;

@Controller
public class BuyerController {

	@Autowired
	private BuyerDao buyerdao;
	
	public List<Buyer> getSafeBuyerList(){
		return buyerdao.getSafeBuyerList();
	}
	
	public Buyer getSafeBuyer(int id){
		return buyerdao.getSafeBuyer(id);
	}
	
	public Buyer createSafeBuyer(BuyerDto buyerdto){
		return buyerdao.createSafeBuyer(buyerdto.fromDto(buyerdto));
	}
	
	public void deleteSafeBuyer(int id){
		buyerdao.deleteSafeBuyer(id);
	}
	
	public void updateSafeBuyer(BuyerDto buyerdto){
		buyerdao.updateSafeBuyer(buyerdto.fromDto(buyerdto));
	}

	public List<Buyer> existingBuyerWithId(String name){
		return buyerdao.existingBuyerWithId(name);
	}
}
