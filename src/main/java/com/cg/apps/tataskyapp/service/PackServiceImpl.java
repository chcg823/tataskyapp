package com.cg.apps.tataskyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.tataskyapp.dao.PackDao;
import com.cg.apps.tataskyapp.entities.Pack;

@Service
public class PackServiceImpl implements PackService {

	@Autowired
	PackDao packDao;
	
	@Override
	public void addPack(Pack pack) {
		// TODO Auto-generated method stub
		packDao.save(pack);
	}

	@Override
	public List<Pack> getPacks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePack(Pack pack) {
		// TODO Auto-generated method stub

	}

}
