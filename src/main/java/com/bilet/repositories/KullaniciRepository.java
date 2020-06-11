package com.bilet.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bilet.model.Kullanici;

public interface KullaniciRepository extends CrudRepository<Kullanici, Long> {
	
}
