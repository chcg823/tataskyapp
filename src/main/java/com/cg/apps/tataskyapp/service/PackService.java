package com.cg.apps.tataskyapp.service;

import java.util.List;

import com.cg.apps.tataskyapp.entities.Pack;

public interface PackService {
	void addPack(Pack pack);
	void removePack(Pack pack);
	List<Pack> getPacks();
}
