package com.bilet.services;

import java.util.Map;
import java.util.Set;

import com.bilet.model.Havayolu;

public interface HavayoluService {
	Havayolu kaydetHavayolu(Havayolu havayolu);
	void silId(Long id);
	Havayolu bulId(Long id);
	Set<Havayolu> havayoluList();
	Map<Long,String> mapHavayoluList();
	
	
}