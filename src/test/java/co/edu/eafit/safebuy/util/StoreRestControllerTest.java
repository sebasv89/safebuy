package co.edu.eafit.safebuy.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import co.edu.eafit.safebuy.infraestructure.persistence.util.JpaPersistenceService;
import co.edu.eafit.safebuy.interfaces.controller.StoreRestController;

public class StoreRestControllerTest {
	
	StoreRestController sut;
	
	@Mock private JpaPersistenceService jpaPersistenceService;

	@Before
	public void setUp() throws Exception {
		sut = new StoreRestController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//sut.getStoreList(response)
		fail("Not yet implemented");
	}

}
