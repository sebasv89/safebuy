package com.talosdigital.safebuy.util.dto;

import com.talosdigital.safebuy.domain.model.Buyer;
import com.talosdigital.safebuy.domain.model.Store;

public class BuyerDto {

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	private String name;
	private String lastName;
	private Store store;
	public Buyer fromDto(BuyerDto dto){
		Buyer buyer = new Buyer();
		if (dto.getLastName() != null) {
			buyer.setLastName(dto.getName());
		}
		if (dto.getName() != null) {
			buyer.setName(dto.getName());
		}
		if (dto.getStore() != null) {
			buyer.setStore(dto.getStore());
		}
		return buyer;
	}
	
	public BuyerDto fromBuyer(Buyer buyer){
		BuyerDto buyerdto = new BuyerDto();
		if (buyer.getLastName() != null) {
			buyerdto.setLastName(buyer.getName());
		}
		if (buyer.getName() != null) {
			buyerdto.setName(buyer.getName());
		}
		if (buyer.getStore() != null) {
			buyerdto.setStore(buyer.getStore());
		}
		return buyerdto;
	}
}
