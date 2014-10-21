package com.talosdigital.safebuy.test;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mock;

import com.talosdigital.safebuy.domain.model.Buyer;
import com.talosdigital.safebuy.domain.model.Store;
import com.talosdigital.safebuy.interfaces.controller.BuyerRestController;
import com.talosdigital.safebuy.persistence.dao.BuyerDao;
import com.talosdigital.safebuy.util.Transformer.BuyerTransformer;
import com.talosdigital.safebuy.util.dto.BuyerDto;

import static org.mockito.Mockito.*;
//import static org.junit.*;
@RunWith(MockitoJUnitRunner.class)
public class BuyerRestControllerTest {
	
	private Buyer buyer= new Buyer();
	@InjectMocks
	 private BuyerRestController buyerController;
	@Mock private BuyerDao buyerdao;
	@Mock private BuyerDto buyerDto = new BuyerDto();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	@Before
	public void init(){
		buyer.setLastName("Last Name" + Math.random());
		buyer.setName("Name" + Math.random());
		buyer.setStore(new Store());
		buyerDto =BuyerTransformer.toBuyerDto(buyer);
	}

	@Test
	public void createSafeBuyerFromRestController() {
		//when insert and entity return the entity
		when(buyerdao.createSafeBuyer(buyer)).thenReturn(buyer);
		buyerController.createSafeBuyer(buyerDto);
		verify(buyerdao).createSafeBuyer(buyer);
	}
	


}
