package com.bilet.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.ws.rs.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bilet.model.HavaYoluHavaAlani;
import com.bilet.repositories.HavayoluHavaalaniRepository;

@Service
public class HavaYoluHavaAlaniServiceImpl implements HavaYoluHavaAlaniService {
	
	private HavayoluHavaalaniRepository havayoluHavaalaniRepository;
	
	

	public HavaYoluHavaAlaniServiceImpl(HavayoluHavaalaniRepository havayoluHavaalaniRepository) {
		this.havayoluHavaalaniRepository = havayoluHavaalaniRepository;
	}

	@Override
	@Transactional
	public HavaYoluHavaAlani kaydetHavaYoluHavaAlan(HavaYoluHavaAlani havaYoluHavaAlani) {
		// TODO Auto-generated method stub
		return havayoluHavaalaniRepository.save(havaYoluHavaAlani);
	}

	@Override
	@Transactional
	public void silId(Long id) {
		// TODO Auto-generated method stub
	  havayoluHavaalaniRepository.deleteById(id);
	}



	@Override
	public HavaYoluHavaAlani bulId(Long id) {
		// TODO Auto-generated method stub
		Optional<HavaYoluHavaAlani> havaYoluHavaAlani = havayoluHavaalaniRepository.findById(id);
		if (!havaYoluHavaAlani.isPresent()) {
			 throw new NotFoundException("Kayıt yok  ID " + id.toString() );
		}
		return havaYoluHavaAlani.get();
	}

	@Override
	public Set<HavaYoluHavaAlani> havaYoluHavaAlaniListe() {
		// TODO Auto-generated method stub
		Set<HavaYoluHavaAlani> havaYoluHavaAlaniuset = new HashSet<>();
		havayoluHavaalaniRepository.findAll().iterator().forEachRemaining(havaYoluHavaAlaniuset::add);
		return havaYoluHavaAlaniuset;
	}
	
	
	
	
	
	
	

}
