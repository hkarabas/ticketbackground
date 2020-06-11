package com.bilet.services;

import java.util.Set;

import com.bilet.model.Kullanici;

public interface KullaniciService {
	
	Kullanici saveHavayolu(Kullanici kullanici);
	void silId(Long id);
	Kullanici bulId(Long id);
	Set<Kullanici> kullaniciList();
}
