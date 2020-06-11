package com.bilet.services;

import java.util.Optional;
import java.util.Set;

import com.bilet.model.Takvim;

public interface TakvimService {
	Takvim kaydetTakvim(Takvim takvim);
	void silId(Long id);
	Takvim bulId(Long id);
	Set<Takvim> takvimList();
	Optional<Takvim> bulPnr(String pnr);

}
