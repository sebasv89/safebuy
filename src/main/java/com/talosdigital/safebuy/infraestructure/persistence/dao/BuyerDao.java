package com.talosdigital.safebuy.infraestructure.persistence.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talosdigital.safebuy.infraestructure.persistence.util.PersistenceService;
import com.talosdigital.safebuy.domain.model.Buyer;
/**
 * This is a Data Access Object for Buyers
 * @version 16/Oct/2014
 * @author jhenaoz
 */
@Repository
public class BuyerDao {

	@Autowired
	private PersistenceService persistence;
	
	/**
	 * Retrieve all the buyers in the current database
	 * @return List, with all the buyers, the search dont produce result, the list
	 * will be empty
	 */
	public List<Buyer> getSafeBuyerList(){
		return persistence.executeQuery(Buyer.class, "SELECT b FROM Buyer b");
	}
	
	/**
	 * Retrieve a single Buyer from database
	 * @param id, id from the buyer to search in the database
	 * @return Buyer, a buyer object finded in the database, or null if there is
	 * no result
	 */
	public Buyer getSafeBuyer(int id){
		return persistence.findById(Buyer.class, id);
	}
	/**
	 * This method create a single buyer in DB
	 * @param buyer, with the params setted
	 * @return BuyerCreated, and object that represent the creation in the DB;
	 */
	public Buyer createSafeBuyer(Buyer buyer){
		return persistence.save(buyer);
	}
	/**
	 * This method update a single buyer in the database
	 * @param buyer, object to be updated.
	 */
	public void updateSafeBuyer(Buyer buyer){
		persistence.update(buyer);
	}
	
	/**
	 * Remove a single buyer from the database, searching by id and later
	 * removing it.
	 * @param id, id of the object to be removed.
	 */
	public void deleteSafeBuyer(int id){
		persistence.remove(persistence.findById(Buyer.class, id));
	}
	
	/**
	 * This method get all the buyers with the name equal to the param name
	 * @param name, name to be searched
	 * @return a list of buyers wit name =name
	 */
	public List<Buyer> existingBuyerWithId(String name){
		return persistence.
				executeQuery(Buyer.class, "SELECT b FROM Buyer b WHERE b.name = '" + name + "'");
	}
}
