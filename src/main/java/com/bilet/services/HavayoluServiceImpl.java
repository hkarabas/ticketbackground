package com.bilet.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.ws.rs.NotFoundException;

import org.springframework.stereotype.Service;

import com.bilet.model.Havayolu;
import com.bilet.repositories.HavaalaniRepository;
import com.bilet.repositories.HavayoluHavaalaniRepository;
import com.bilet.repositories.HavayoluRepository;

@Service
public class HavayoluServiceImpl implements HavayoluService {
	
	private final HavaalaniRepository havalaaniRepository;
	private final HavayoluRepository havayoluRepositorty;
	private final HavayoluHavaalaniRepository havayoluHavaalaniRepository;
	

	public HavayoluServiceImpl(HavaalaniRepository havalaaniRepository, HavayoluRepository havayoluRepositorty,
			HavayoluHavaalaniRepository havayoluHavaalaniRepository) {
		
		this.havalaaniRepository = havalaaniRepository;
		this.havayoluRepositorty = havayoluRepositorty;
		this.havayoluHavaalaniRepository = havayoluHavaalaniRepository;
	}

	@Override
	public Havayolu kaydetHavayolu(Havayolu havayolu) {
		return this.havayoluRepositorty.save(havayolu);
	}

	@Override
	public void silId(Long id) {
		this.havayoluRepositorty.deleteById(id);
		
	}

	@Override
	public Havayolu bulId(Long id) {
		Optional<Havayolu> havayolu = havayoluRepositorty.findById(id);
		if (!havayolu.isPresent()) {
			 throw new NotFoundException("Havayolu yok  ID " + id.toString() );
		}
		return havayolu.get();
		
	}

	@Override
	public Set<Havayolu> havayoluList() {
		// TODO Auto-generated method stub
		
		Set<Havayolu> havayoluset = new HashSet<>();
		havayoluRepositorty.findAll().iterator().forEachRemaining(havayoluset::add);
		return havayoluset;
	}

	@Override
	public Map<Long, String> mapHavayoluList() {
		Map<Long, String> map = new HashMap<Long, String>();
		for(Havayolu havayolu:havayoluList() ) {
			map.put(havayolu.getId(),havayolu.getHavayoluad() );
		}
		return map;
	}
	
	
}
