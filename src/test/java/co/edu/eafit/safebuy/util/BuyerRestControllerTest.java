package co.edu.eafit.safebuy.util;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.talosdigital.safebuy.controllers.BuyerController;
import com.talosdigital.safebuy.domain.model.Buyer;
import com.talosdigital.safebuy.domain.model.Store;
import com.talosdigital.safebuy.persistence.util.JpaPersistenceService;

@RunWith(MockitoJUnitRunner.class)
public class BuyerRestControllerTest {
	
	private Buyer buyer= new Buyer();
	
	@InjectMocks
	private BuyerController buyerController = new BuyerController();
	@Mock 
	JpaPersistenceService persistenceService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	@Before
	public void init(){
		buyer.setLastName("Last Name" + Math.random());
		buyer.setName("Name" + Math.random());
		buyer.setStore(persistenceService.findById(Store.class, 1));
	}

	@Test
	public void createSafeBuyer() {
		Buyer buyerAux =persistenceService.save(buyer);
		if (buyerAux != null) {
			Assert.assertEquals(buyerAux, buyerAux);
		}else{
			fail();
		}
	}

}
