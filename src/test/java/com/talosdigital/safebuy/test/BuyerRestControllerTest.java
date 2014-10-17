package com.talosdigital.safebuy.test;


import org.hibernate.ejb.criteria.expression.SearchedCaseExpression.WhenClause;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.After;
import org.mockito.Mock;

import com.talosdigital.safebuy.controllers.BuyerController;
import com.talosdigital.safebuy.domain.model.Buyer;
import com.talosdigital.safebuy.domain.model.Store;
import com.talosdigital.safebuy.persistence.util.JpaPersistenceService;
import com.talosdigital.safebuy.util.dto.BuyerDto;

import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class BuyerRestControllerTest {
	
	private Buyer buyer= new Buyer();
	private BuyerDto buyerdto = new BuyerDto();
	private Store store = new Store();
	
	@Mock
	private BuyerController buyerController = new BuyerController();
	 
	@Mock private JpaPersistenceService persistenceService;

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
	public void createSafeBuyer() {
		when(buyerController.createSafeBuyer(buyerdto)).thenReturn(buyer);
		Buyer createdBuyer = buyerController.createSafeBuyer(buyerdto);
		Assert.assertEquals(createdBuyer, buyer);
		verify(buyerController).createSafeBuyer(buyerdto);
		
	}

}
