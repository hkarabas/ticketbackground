package com.bilet.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.ws.rs.NotFoundException;

import org.springframework.stereotype.Service;

import com.bilet.model.Musteri;
import com.bilet.repositories.MusteriRepository;

@Service
public class MusteriServiceImpl implements MusteriService {
	
	private final MusteriRepository musteriRepository;
	

	public MusteriServiceImpl(MusteriRepository musteriRepository) {
		this.musteriRepository = musteriRepository;
	}

	@Override
	public Musteri saveMusteri(Musteri musteri) {
		return musteriRepository.save(musteri);
	}

	@Override
	public void silId(Long id) {
		musteriRepository.deleteById(id);
		
	}

	@Override
	public Musteri bulId(Long id) {
		Optional<Musteri> musteri = musteriRepository.findById(id);
		
		if(!musteri.isPresent()) {
			throw new NotFoundException("Musteri yok  ID " + id.toString() );
		}
		return musteri.get();
		
		
	}

	@Override
	public Set<Musteri> musteriList() {
		Set<Musteri> musteriList = new HashSet<>();
		musteriRepository.findAll().iterator().forEachRemaining(musteriList::add);
		return musteriList;
	}

	@Override
	public Musteri bulTcno(String tcno) {
	 Optional<Musteri> musteri =	musteriRepository.findByTcno(tcno);
	 	if (!musteri.isPresent()) {
	 		return null;
	 	} else {
	 	   return	musteri.get();
	 	}
	}
	
}
