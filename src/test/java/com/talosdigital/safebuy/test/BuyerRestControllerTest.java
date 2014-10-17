package com.talosdigital.safebuy.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mock;
import org.springframework.dao.support.DaoSupport;

import com.talosdigital.safebuy.controllers.BuyerController;
import com.talosdigital.safebuy.domain.model.Buyer;
import com.talosdigital.safebuy.domain.model.Store;
import com.talosdigital.safebuy.persistence.dao.BuyerDao;
import com.talosdigital.safebuy.persistence.util.JpaPersistenceService;
import com.talosdigital.safebuy.util.dto.BuyerDto;

import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class BuyerRestControllerTest {
	
	private Buyer buyer= new Buyer();
	private BuyerDto buyerdto = new BuyerDto();
	@InjectMocks
	private BuyerController buyerController = new BuyerController();
	 
	@Mock private BuyerDao buyerdao;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	@Before
	public void init(){
		buyer.setLastName("Last Name" + Math.random());
		buyer.setName("Name" + Math.random());
		buyer.setStore(new Store());
		buyerdto = buyerdto.fromBuyer(buyer);
	}

	@Test
	public void createSafeBuyerFromControllerAndDao() {
		//when insert and entity return the entity
		when(buyerdao.createSafeBuyer(buyerdto.fromDto(buyerdto))).thenReturn(buyer);
		Buyer createdBuyer = buyerController.createSafeBuyer(buyerdto);
		Assert.assertEquals(createdBuyer, buyer);
		verify(buyerdao).createSafeBuyer(buyerdto.fromDto(buyerdto));
	}
	
//	@Test
//	public void createSafeBuyerInDatabase(){
//		Buyer createdBuyer = buyerController.createSafeBuyer(buyerdto);
//		Assert.assertTrue(createdBuyer != null);
//	}
//	@After
//	public void clean(){
//		//remove the posible creations
//		buyerController.deleteSafeBuyer(buyer.getId());
//	}

}
