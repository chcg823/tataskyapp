package com.cg.apps.tataskyapp.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.tataskyapp.dao.RechargeDao;
import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;
import com.cg.apps.tataskyapp.entities.Recharge;

@Service
public class RechargeServiceImpl implements RechargeService{

	@Autowired
	RechargeDao rechargeDao;

	@Override
	public Recharge createRecharge(Pack pack, Account account) {
		Recharge recharge = new Recharge();
		
		LocalDate date = LocalDate.now();
		recharge.setAccount(account);
		recharge.setAmount(pack.getCost());
		recharge.setDaysValidity(pack.getDaysValidity());
		recharge.setPlanDescription(pack.getDescription());
		recharge.setPlanName(pack.getPlanName());
		recharge.setPurchasedDate(date);
		recharge.setActive(true);
		return rechargeDao.save(recharge);
	}

	@Override
	public Recharge update(Recharge recharge) {
		Recharge rechargeUpdated = new Recharge();
		rechargeDao.deleteById(recharge.getId());
		rechargeUpdated.setAccount(recharge.getAccount());
		rechargeUpdated.setAmount(recharge.getAmount());
		rechargeUpdated.setDaysValidity(recharge.getDaysValidity());
		rechargeUpdated.setPlanDescription(recharge.getPlanDescription());
		rechargeUpdated.setPlanName(recharge.getPlanName());
		return rechargeUpdated;
	}

	@Override
	public List<Recharge> findRechargesForUserInDescendingOrderByPurchasedDate(Account account) {
		List<Recharge> rechargeList = rechargeDao.findAll();
		rechargeList = rechargeList.stream().filter((r)->r.getAccount().getAccountId()==account.getAccountId())
					.collect(Collectors.toList());
		Collections.sort(rechargeList,
			new Comparator<Recharge>(){
				public int compare(Recharge r1, Recharge r2) {
					return r2.getPurchasedDate().compareTo(r1.getPurchasedDate());
				}
			});
		
		return rechargeList;
	}

	@Override
	public int rechargesForUserCount(Account account) {
		List<Recharge> recharges = account.getRecharges();
		return recharges.size();
	}

	@Override
	public List<Recharge> findAllRechargesInPeriod(LocalDate startDate, LocalDate endDate) {
		List<Recharge> rechargeList = rechargeDao.findAll();
		
		return rechargeList;
	}

	@Override
	public int countRechargesInPeriod(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double totalRevenueInPeriod(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rechargesCount(Pack pack) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Recharge expireIfValidityFinished(Account account, Recharge recharge) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Recharge> findAllRechargesInPeriod(LocalDate startDate, LocalDate endDate) {
//		List<Recharge> rechargeList = rechargeDao.findAll();
//		
//		return rechargeList;
//	}
//
//	@Override
//	public int countRechargesInPeriod(LocalDate startDate, LocalDate endDate) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public double totalRevenueInPeriod(LocalDate startDate, LocalDate endDate) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int rechargesCount(Pack pack) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public Recharge expireIfValidityFinished(Account account, Recharge recharge) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
