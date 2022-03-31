package com.cg.apps.tataskyapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.tataskyapp.dao.PackDao;
import com.cg.apps.tataskyapp.entities.Pack;

@Service
public class PackServiceImpl implements PackService {
	List<Pack> packList=new ArrayList<Pack>();

	@Autowired
	PackDao packDao;

	@Override
	public void addPack(Pack pack) {
		Pack newPack = new Pack();
		newPack.setId(pack.getId());
		newPack.setCost(pack.getCost());
		newPack.setDaysValidity(pack.getDaysValidity());
		newPack.setDescription(pack.getDescription());
		newPack.setPlanName(pack.getPlanName());
		packDao.save(newPack);
	}
	@Override
	public void removePack(Pack pack) {
		packDao.delete(pack);
	}
	@Override
	public Pack update(Pack pack) {
		Pack packUpdate=new Pack();
		packUpdate.setId(pack.getId());
		packUpdate.setCost(pack.getCost());
		packUpdate.setDaysValidity(pack.getDaysValidity());
		packUpdate.setDescription(pack.getDescription());
		packUpdate.setPlanName(pack.getPlanName());
		packDao.save(packUpdate);
		return packUpdate;
	}
	@Override
	public Pack findPackById(Long packId) {
		Optional<Pack> opt = packDao.findById(packId);
		Pack p = opt.get();
		return p;
	}
	@Override
	public List<Pack>findPacksGreaterThanAmount(double amount){
		List<Pack> packList=packDao.findAll();
		List<Pack> packsBasedOnAmount=new ArrayList<>();
		for(Pack p:packList) {
			if(p.getCost()>amount)
				packsBasedOnAmount.add(p);
		}
		return packsBasedOnAmount;
	}
	@Override
	public List<Pack>findPacksInAscendingOrderByCost(){
		List<Pack> packList = packDao.findAll();
		//List<Pack> list=new ArrayList<>();
    	/*list.stream()
    	.sorted((p1,p2)->p1.getCost().compareTo(p2.getCost()));*/
		Collections.sort(packList,(p1,p2)->{
			return p1.getCost().compareTo(p2.getCost());
		});
		return packList;

	}
	@Override
	public List<Pack> findPacksInAscendingOrderByDaysValidity(){
		List<Pack> packList = packDao.findAll();
		Collections.sort(packList,(p1,p2)->{
			return p1.getDaysValidity().compareTo(p2.getDaysValidity());
		});
		return packList;
	}

	/**
	 * finds packs in descending order of popularity
	 *  popularity is measured by number of recharges done on a pack
	 */
	@Override
	public List<Pack> popularPacks(){
		List<Pack> packList=packDao.findAll();
		int count=0;
		List<Integer> list=new ArrayList<>();
		RechargeServiceImpl rsi=new RechargeServiceImpl();
		for(Pack p:packList) {
			count=rsi.rechargesCount(p);
			list.add(count);
		}
		return packList;

	}

	@Override
	public void deleteByPackId(Long packId) {
		packDao.deleteById(packId);
	}

}
