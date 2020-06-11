package com.bilet.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bilet.model.Musteri;

public interface MusteriRepository extends CrudRepository<Musteri, Long> {
	Optional<Musteri> findByTcno(String tcno);
}
