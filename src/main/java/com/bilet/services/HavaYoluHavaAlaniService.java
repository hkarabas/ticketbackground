package com.bilet.services;

import java.util.Set;

import com.bilet.model.HavaYoluHavaAlani;

public interface HavaYoluHavaAlaniService {
	
	HavaYoluHavaAlani kaydetHavaYoluHavaAlan(HavaYoluHavaAlani havaYoluHavaAlani);
	void silId(Long id);
	HavaYoluHavaAlani bulId(Long id);
	Set<HavaYoluHavaAlani> havaYoluHavaAlaniListe();

}
