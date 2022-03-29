package com.cg.apps.tataskyapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.tataskyapp.dao.RechargeDao;
import com.cg.apps.tataskyapp.entities.Recharge;

@Service
public class RechargeServiceImpl implements RechargeService{

	@Autowired
	RechargeDao rechargeDao;
	
	@Override
	public void addRecharge(Recharge recharge) {
		// TODO Auto-generated method stub
		rechargeDao.save(recharge);
		
	}
	
}
