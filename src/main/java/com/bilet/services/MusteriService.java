package com.bilet.services;

import java.util.Set;

import com.bilet.model.Musteri;

public interface MusteriService  {
	
	Musteri saveMusteri(Musteri musteri);
	void silId(Long id);
	Musteri bulId(Long id);
	Set<Musteri> musteriList();
	Musteri bulTcno(String tcno);
	

}
