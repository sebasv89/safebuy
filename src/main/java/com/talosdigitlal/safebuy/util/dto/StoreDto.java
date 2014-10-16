package com.talosdigitlal.safebuy.util.dto;

import com.talosdigital.safebuy.domain.model.Store;

public class StoreDto {

	private String name;
	private String nit;
	
	public Store fromDto(StoreDto storedto){
		Store store = new Store();
		if (storedto.getName() != null) {
			store.setName(storedto.getName());
		}
		if (storedto.getNit() != null) {
			store.setNit(storedto.getNit());
		}
		return store;
	}
	public StoreDto fromStore(Store store){
		StoreDto storedto = new StoreDto();
		if (store.getName() != null) {
			storedto.setName(store.getName());
		}
		if (store.getNit() != null) {
			storedto.setNit(store.getNit());
		}
		return storedto;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	
	
}
