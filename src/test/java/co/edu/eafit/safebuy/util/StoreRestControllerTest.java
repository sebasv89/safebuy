package co.edu.eafit.safebuy.util;

import java.awt.List;
import java.util.LinkedList;

import junit.framework.Assert;

import javax.servlet.http.HttpServletResponse;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import co.edu.eafit.safebuy.domain.model.comprador.Store;
import co.edu.eafit.safebuy.infraestructure.persistence.util.PersistenceService;
import co.edu.eafit.safebuy.interfaces.controller.StoreRestController;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StoreRestControllerTest {
	
	@InjectMocks
	private StoreRestController sut;
	
	@Mock private PersistenceService persistenceService;
	@Mock private Store store;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Before
	public void setUp() throws Exception {
		sut = new StoreRestController();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void getListStore() {
		//sut.getStoreList(response);
		//Assert.assertEquals("", 0, 0);
	}
	
	@Test
    public void testone() {
		List mockedList = mock(List.class);
		//using mock object
		mockedList.add("one");
		mockedList.clear();
		//verification
		verify(mockedList).add("one");
		verify(mockedList).clear();		

    }
	
	@Test
	public void testtwo(){
		LinkedList mockedList = mock(LinkedList.class);
		when(mockedList.get(0)).thenReturn("first");
		//when(mockedList.get(1)).thenThrow(new RuntimeException());
		System.out.println(mockedList.get(0));
		System.out.println(mockedList.get(1));
		System.out.println(mockedList.get(999));(mockedList).get(0);
	}

	@Test
	public void testthree(){

		LinkedList mockedList = mock(LinkedList.class);
		when(mockedList.get(anyInt())).thenReturn("element");
		//when(mockedList.contains(argThat(isValid()))).thenReturn("element");
		System.out.println(mockedList.get(999));
		verify(mockedList).get(anyInt());
	}
	
	@Test
	public void testfour(){
		
		List mockedList = mock(List.class);
		mockedList.add("once");
		mockedList.add("twice");
		mockedList.add("twice");
		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");
		verify(mockedList, never()).add("never happened");
		verify(mockedList, atLeastOnce()).add("three times");
		//verify(mockedList, atLeast(2)).add("five times");
		verify(mockedList, atMost(5)).add("three times");
		
	}
	
	@Test
	public void testfive(){
		List mockedList = mock(List.class);
		doThrow(new RuntimeException()).when(mockedList).clear();
		mockedList.clear();
	}
	
	@Test
	public void testsix(){
		List singleMock = mock(List.class);
		singleMock.add("was added first");
		singleMock.add("was added second");
		InOrder inOrder = inOrder(singleMock);
		inOrder.verify(singleMock).add("was added first");
		inOrder.verify(singleMock).add("was added second");
		List firstMock = mock(List.class);
		List secondMock = mock(List.class);
		firstMock.add("was called first");
		secondMock.add("was called second");
		InOrder inOrder2 = inOrder(firstMock, secondMock);
		inOrder2.verify(firstMock).add("was called first");
		inOrder2.verify(secondMock).add("was called second");
	}
	
	@Test
	public void testseven(){
		List mockOne = mock(List.class);
		mockOne.add("one");
		verify(mockOne).add("one");
		verify(mockOne, never()).add("two");
		//verifyZeroInteractions(mockTwo, mockThree);

	}
	
	@Test
	public void testeight(){
		List mockedList = mock(List.class);
		mockedList.add("one");
		//mockedList.add("two");
		verify(mockedList).add("one");
		verifyNoMoreInteractions(mockedList);
	}
	
	@Test
	public void testten(){
		List mock = mock(List.class);
		//when(mock.add("some arg"))
		  //.thenThrow(new RuntimeException())
		  //.thenReturn("foo");
		//mock.clear();
		//System.out.println(mock.add("some arg"));
		//System.out.println(mock.add("some arg"));

	}
	
	@Test
	public void testtirteen(){
		/*List list = new List();
		List spy = spy(list);
		when(spy.size()).thenReturn(100);
		spy.add("one");
		spy.add("two");
		System.out.println(spy.get(0));
		System.out.println(spy.size());
		verify(spy).add("one");
		verify(spy).add("two");
*/
	}

}
