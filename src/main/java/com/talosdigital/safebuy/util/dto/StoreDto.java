package com.talosdigital.safebuy.util.dto;

import com.talosdigital.safebuy.domain.model.Store;

public class StoreDto {

	private int id;
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
		store.setId(storedto.getId());
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
		storedto.setId(store.getId());
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
