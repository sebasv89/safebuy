package com.talosdigital.safebuy.infraestructure.persistence.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talosdigital.safebuy.domain.model.Store;
import com.talosdigital.safebuy.infraestructure.persistence.util.PersistenceService;
import com.talosdigitlal.safebuy.util.dto.StoreDto;

/**
 * This Class is a DAO from buyer Table
 * @author jhenaoz
 */
@Repository
public class StoreDao {

	@Autowired
	private PersistenceService persistence;
	
	/**
	 * This method retrieve all the stores in the database
	 * @return List, with all the stores present.
	 */
	public List<Store> getStoreList(){
		return persistence.executeQuery(Store.class, "SELECT s FROM Store s");
	}
	
	public Store getStore(int id){
		return persistence.findById(Store.class, id);
	}
	
	public Store createStore(StoreDto storedto){
		return persistence.save(storedto.fromDto(storedto));
	}
	
	public Store updateStore(StoreDto storedto){
		return persistence.update(storedto.fromDto(storedto));
	}
	
	public void deleteStore(int id){
		persistence.remove(persistence.findById(Store.class, id));
	}
	
}