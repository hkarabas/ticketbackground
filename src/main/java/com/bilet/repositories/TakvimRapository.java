package com.bilet.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bilet.model.Takvim;

public interface TakvimRapository extends CrudRepository<Takvim, Long> {
	Optional<Takvim>  findByPnr(String pnr);
}
