package com.talosdigital.safebuy.infraestructure.persistence.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talosdigital.safebuy.infraestructure.persistence.util.PersistenceService;
import com.talosdigital.safebuy.domain.model.Buyer;
import com.talosdigitlal.safebuy.util.dto.BuyerDto;

@Component
public class BuyerDao {

	@Autowired
	private PersistenceService persistence;
	
	public List<Buyer> getSafeBuyerList(){
		return persistence.executeQuery(Buyer.class, "SELECT b FROM Buyer b");
	}
	
	public Buyer getSafeBuyer(int id){
		return persistence.findById(Buyer.class, id);
	}
	public Buyer createSafeBuyer(BuyerDto buyerdto){
		return persistence.save(buyerdto.fromDto(buyerdto));
	}
	public void updateSafeBuyer(BuyerDto buyerdto){
		persistence.update(buyerdto.fromDto(buyerdto));
	}
	public void deleteSafeBuyer(int id){
		persistence.remove(persistence.findById(Buyer.class, id));
	}
}
