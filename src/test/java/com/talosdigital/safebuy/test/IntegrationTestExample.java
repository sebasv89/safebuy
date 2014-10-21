package com.talosdigital.safebuy.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.talosdigital.safebuy.util.dto.BuyerDto;


public class IntegrationTestExample {

	@Test
	public void testCreateBuyer(){
		   HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);

		    RestTemplate template = new RestTemplate();
		    BuyerDto buyerDto = new BuyerDto();
		    buyerDto.setName("Sebastian");
		    buyerDto.setLastName("V");
		    HttpEntity<BuyerDto> requestEntity = new HttpEntity<BuyerDto>(buyerDto
		        ,headers);

		    ResponseEntity<RestBuyerDto> entity = template.postForEntity(
		        "http://localhost:8080/safebuy/rest/buyer",
		        requestEntity, RestBuyerDto.class);


		    assertEquals(HttpStatus.CREATED, entity.getStatusCode());
		    RestBuyerDto order = entity.getBody();

	}
}
