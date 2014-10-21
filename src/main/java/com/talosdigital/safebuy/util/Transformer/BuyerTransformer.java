package com.talosdigital.safebuy.util.Transformer;

import com.talosdigital.safebuy.domain.model.Buyer;
import com.talosdigital.safebuy.util.dto.BuyerDto;

public class BuyerTransformer {

	public static Buyer toBuyer(BuyerDto buyerDto){
		Buyer buyer = new Buyer();
		if (buyerDto.getName() != null) {
			buyer.setName(buyerDto.getName());
		}
		if (buyerDto.getLastName() != null) {
			buyer.setLastName(buyerDto.getLastName());
		}
		buyer.setId(buyerDto.getId());
		return buyer;
	}
	
	public static BuyerDto toBuyerDto(Buyer buyer){
		BuyerDto buyerDto = new BuyerDto();
		if (buyer.getName() != null) {
			buyerDto.setName(buyer.getName());
		}
		if (buyer.getLastName() != null) {
			buyerDto.setLastName(buyer.getLastName());
		}
		buyerDto.setId(buyer.getId());
		return buyerDto;
	}
	
}
