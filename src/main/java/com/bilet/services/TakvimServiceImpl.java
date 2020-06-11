package com.bilet.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.ws.rs.NotFoundException;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.bilet.model.Takvim;
import com.bilet.repositories.TakvimRapository;

@Service
public class TakvimServiceImpl implements TakvimService {
	
	private final TakvimRapository takvimRapository;
	

	public TakvimServiceImpl(TakvimRapository takvimRapository) {
		this.takvimRapository = takvimRapository;
	}

	@Override
	public Takvim kaydetTakvim(Takvim takvim) {
		
		int length = 10;
		String pnr = RandomStringUtils.random(length, true, true);
		takvim.setPnr(pnr);
		return takvimRapository.save(takvim);
		
		
	}
	

	@Override
	public void silId(Long id) {
		takvimRapository.deleteById(id);
		
	}

	@Override
	public Takvim bulId(Long id) {
		Optional<Takvim> takvim = takvimRapository.findById(id);
		if (!takvim.isPresent()) {
			throw new NotFoundException("Takvim yok  ID " + id.toString() );
		}
		return takvim.get();
	}

	@Override
	public Set<Takvim> takvimList() {
		// TODO Auto-generated method stub
		Set<Takvim> takvimList = new HashSet();
		
		takvimRapository.findAll().iterator().forEachRemaining(takvimList::add);
		return takvimList;
	}

	@Override
	public Optional<Takvim> bulPnr(String pnr) {
		return takvimRapository.findByPnr(pnr);
	}

}
