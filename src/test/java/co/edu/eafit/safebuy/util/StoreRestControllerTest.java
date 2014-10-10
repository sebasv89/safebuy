package co.edu.eafit.safebuy.util;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.talosdigital.safebuy.domain.model.Store;
import com.talosdigital.safebuy.infraestructure.persistence.util.PersistenceService;
import com.talosdigital.safebuy.interfaces.controller.StoreRestController;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StoreRestControllerTest {
	
	private List<Store> listDefault;
	private Store storeDefault = new Store();
	private Store otherStoreDefault = new Store();
	
	@InjectMocks
	private StoreRestController sut = new StoreRestController();
	
	@Mock private PersistenceService persistenceService;
	@Mock private Store store;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Before
	public void setUp() throws Exception {
		listDefault = new ArrayList<Store>();
		
		storeDefault.setId(0);
		storeDefault.setName("jesse");
		storeDefault.setNit("900100200");
		listDefault.add(storeDefault);
		otherStoreDefault.setId(1);
		otherStoreDefault.setName("javier");
		otherStoreDefault.setNit("900100201");
		listDefault.add(otherStoreDefault);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void getListStoreTest(){
		when(persistenceService.executeQuery(Store.class, "SELECT s FROM Store s")).thenReturn(listDefault);
		List<Store> returnedList= sut.getStoreList();
		Assert.assertEquals(listDefault, returnedList);
		verify(persistenceService).executeQuery(Store.class, "SELECT s FROM Store s");
	}
	
	@Test
	public void getStoreByIdTest(){
		when(persistenceService.findById(Store.class, 0)).thenReturn(storeDefault);
		Store returnedStore= sut.getStore(0);
		Assert.assertEquals(storeDefault, returnedStore);
		verify(persistenceService).findById(Store.class,0);
	}
	
	@Test
	public void createStoreTest(){
		when(persistenceService.save(storeDefault)).thenReturn(storeDefault);
		Store returnedStore= sut.createStore(storeDefault);
		Assert.assertEquals(storeDefault, returnedStore);
		verify(persistenceService).save(storeDefault);
	}
	
	@Test
	public void updateStoreTest(){
		when(persistenceService.update(otherStoreDefault)).thenReturn(otherStoreDefault);
		sut.updateStore(storeDefault,0);
		//Assert.assertEquals(storeDefault, returnedStore);
		verify(persistenceService).update(storeDefault);
	}
	
	@Test
	public void deleteStoreTest(){
		when(persistenceService.findById(Store.class, 0)).thenReturn(storeDefault);
		Store returnedStore= sut.getStore(0);
		sut.deleteStore(0);
		verify(persistenceService).remove(returnedStore);
	}

}
