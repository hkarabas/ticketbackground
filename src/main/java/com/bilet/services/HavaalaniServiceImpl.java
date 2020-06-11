package com.bilet.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.ws.rs.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bilet.model.Havaalani;
import com.bilet.repositories.HavaalaniRepository;
import com.bilet.repositories.HavayoluHavaalaniRepository;
import com.bilet.repositories.HavayoluRepository;





@Service
public class HavaalaniServiceImpl implements HavaalaniService {

		
	private final HavaalaniRepository havalaaniRepository;
	private final HavayoluRepository havayoluRepositorty;
	private final HavayoluHavaalaniRepository havayoluHavaalaniRepository;
	
	
	public HavaalaniServiceImpl(HavaalaniRepository havalaaniRepository,HavayoluRepository havayoluRepositorty,
			HavayoluHavaalaniRepository havayoluHavaalaniRepository) {
		this.havalaaniRepository = havalaaniRepository;
		this.havayoluRepositorty = havayoluRepositorty;
		this.havayoluHavaalaniRepository = havayoluHavaalaniRepository;
	}

	@Override
	@Transactional
	public Havaalani kaydetHavaalani(Havaalani havaalani) {
		// TODO Auto-generated method stub
		
		return havalaaniRepository.save(havaalani);
	}

	@Override
	@Transactional
	public void silId(Long id) {
		havalaaniRepository.deleteById(id);
		
	}

	@Override
	public Havaalani bulId(Long id) {
		// TODO Auto-generated method stub
		 Optional<Havaalani> havaalani = 	havalaaniRepository.findById(id);
		 
		 if (!havaalani.isPresent()) {
			 throw new NotFoundException("Havaalani yok  ID " + id.toString() );
		 } 
		 return havaalani.get();
		 
	}

	@Override
	public Set<Havaalani> havaalaniListe() {
		// TODO Auto-generated method stub
		  Set<Havaalani> havaalaniSet = new HashSet<>();
		  havalaaniRepository.findAll().iterator().forEachRemaining(havaalaniSet::add);
		  return havaalaniSet;
	}

	@Override
	public Map<Long, String> mapHavaalaniList() {
		Map<Long, String> map = new HashMap<Long, String>();
		for(Havaalani havaalani:havaalaniListe() ) {
			map.put(havaalani.getId(),havaalani.getHavalaniad());
		}
		return map;
	}

}
