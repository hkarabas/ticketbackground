package com.bilet.services;

import java.util.Map;
import java.util.Set;

import com.bilet.model.Havaalani;

public interface HavaalaniService {
	
	Havaalani kaydetHavaalani(Havaalani havaalani);
	void silId(Long id);
	Havaalani bulId(Long id);
	Set<Havaalani> havaalaniListe();
	Map<Long,String> mapHavaalaniList();
	
	
}
