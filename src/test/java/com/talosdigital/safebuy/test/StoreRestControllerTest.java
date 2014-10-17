package com.talosdigital.safebuy.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.talosdigital.safebuy.domain.model.Store;
import com.talosdigital.safebuy.interfaces.controller.StoreRestController;
import com.talosdigital.safebuy.persistence.dao.StoreDao;

@RunWith(MockitoJUnitRunner.class)
public class StoreRestControllerTest {
	
//	private List<Store> listDefault;
//	private Store storeDefault = new Store();
//	private Store otherStoreDefault = new Store();
//	private StoreDto storedto = new StoreDto();
	
	@InjectMocks
	private StoreRestController storeRestController= new StoreRestController();
	
	@Mock private StoreDao storeDao;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void getStoreListTest(){
		Store store = new Store();
		when(storeDao.getStoreList()).thenReturn(Collections.singletonList(store));
		
		
		List<Store> result = storeRestController.getStoreList();
		
		verify(storeDao).getStoreList();
		
		Assert.assertEquals(store, result.get(0));
		
	}
	
//	@Before
//	public void setUp() throws Exception {
//		listDefault = new ArrayList<Store>();
//		
//		storeDefault.setId(0);
//		storeDefault.setName("jesse" + Math.random());
//		storeDefault.setNit("900100200");
//		listDefault.add(storeDefault);
//		otherStoreDefault.setId(1);
//		otherStoreDefault.setName("javier" + Math.random());
//		otherStoreDefault.setNit("900100201");
//		listDefault.add(otherStoreDefault);
//		storedto = new StoreDto();
//		storedto = storedto.fromStore(storeDefault);
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//	
//	@Test
//	public void getListStoreTest(){
//		when(persistenceService.executeQuery(Store.class, "SELECT s FROM Store s")).thenReturn(listDefault);
//		List<Store> returnedList= storeRestController.getStoreList();
//		Assert.assertEquals(listDefault, returnedList);
//		verify(persistenceService).executeQuery(Store.class, "SELECT s FROM Store s");
//	}
//	
//	@Test
//	public void getStoreByIdTest(){
//		when(persistenceService.findById(Store.class, 0)).thenReturn(storeDefault);
//		Store returnedStore= storeRestController.getStore(0);
//		Assert.assertEquals(storeDefault, returnedStore);
//		verify(persistenceService).findById(Store.class,0);
//	}
//	
//	@Test
//	public void createStoreTest(){
////		when(persistenceService.save(storeDefault)).thenReturn(storeDefault);
////		Store returnedStore= storeRestController.createStore(storeDefault);
////		Assert.assertEquals(storeDefault, returnedStore);
////		verify(persistenceService).save(storeDefault);
//	}
//	
//	@Test
//	public void updateStoreTest(){
//		when(storedao.updateStore(storedto.fromDto(storedto))).thenReturn(storeDefault);
//		Store returnedStore =storeRestController.updateStore(storedto, 0);
//		Assert.assertEquals(storeDefault, returnedStore);
//	}
//	
//	@Test
//	public void deleteStoreTest(){
//		when(persistenceService.findById(Store.class, 0)).thenReturn(storeDefault);
//		Store returnedStore= storeRestController.getStore(0);
//		storeRestController.deleteStore(0);
//		verify(persistenceService).remove(returnedStore);
//	}

}
