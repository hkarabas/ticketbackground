package com.bilet.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.ws.rs.NotFoundException;

import org.springframework.stereotype.Service;

import com.bilet.model.Kullanici;
import com.bilet.repositories.KullaniciRepository;

@Service
public class KullaniciServiceImpl implements KullaniciService {
	
	private final KullaniciRepository kullaniciRepository;


	public KullaniciServiceImpl(KullaniciRepository kullaniciRepository) {
		this.kullaniciRepository = kullaniciRepository;
	}

	@Override
	public Kullanici saveHavayolu(Kullanici kullanici) {
		return kullaniciRepository.save(kullanici);
	}

	@Override
	public void silId(Long id) {
		kullaniciRepository.deleteById(id);
		
	}

	@Override
	public Kullanici bulId(Long id) {
		Optional<Kullanici> kullanici = kullaniciRepository.findById(id);
		if (!kullanici.isPresent()) {
			 throw new NotFoundException("Kullanici yok  ID " + id.toString() );
		}
		return kullanici.get();
	}

	@Override
	public Set<Kullanici> kullaniciList() {
		// TODO Auto-generated method stub
		 Set<Kullanici> kullaniciSet = new HashSet<>();
		 kullaniciRepository.findAll().iterator().forEachRemaining(kullaniciSet::add);
		 return kullaniciSet;
		 
	}

}
