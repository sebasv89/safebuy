package com.talosdigital.safebuy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.talosdigital.safebuy.domain.model.Store;
import com.talosdigital.safebuy.persistence.dao.StoreDao;
import com.talosdigital.safebuy.util.dto.StoreDto;

@Controller
public class StoreController {

	@Autowired
	private StoreDao storedao;
	
	public List<Store> getStoreList(){
		return storedao.getStoreList();
	}
	
	public Store getStore(int id){
		return storedao.getStore(id);
	}
	public Store createStore(StoreDto storedto){
		return storedao.createStore(storedto.fromDto(storedto));
	}
	
	public Store updateStore(StoreDto storedto){
		return storedao.updateStore(storedto.fromDto(storedto));
	}
	
	public void deleteStore(int id){
		storedao.deleteStore(id);
	}
}
