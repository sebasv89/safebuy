package com.talosdigital.safebuy.util.Transformer;

import com.talosdigital.safebuy.domain.model.Store;
import com.talosdigital.safebuy.util.dto.StoreDto;

public class StoreTransformer {

	
	public static Store toStore(StoreDto storeDto){
		Store store = new Store();
		if (storeDto.getName() != null) {
			store.setName(storeDto.getName());
		}
		if (storeDto.getNit() != null) {
			store.setNit(storeDto.getNit());
		}
		store.setId(storeDto.getId());
		return store;
	}
	
	public static StoreDto toStoreDto(Store store){
		StoreDto storeDto = new StoreDto();
		if (store.getName() != null) {
			storeDto.setName(store.getName());
		}
		if (store.getNit() != null) {
			storeDto.setNit(store.getNit());
		}
		storeDto.setId(store.getId());
		return storeDto;
	}
}
