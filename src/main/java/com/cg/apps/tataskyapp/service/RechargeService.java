package com.cg.apps.tataskyapp.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;
import com.cg.apps.tataskyapp.entities.Recharge;

public interface RechargeService {
	
	Recharge createRecharge(Pack pack, Account account);
	Recharge update(Recharge recharge);
	List<Recharge> findRechargesForUserInDescendingOrderByPurchasedDate(Account account);
	int rechargesForUserCount(Account account);
	List<Recharge> findAllRechargesInPeriod(LocalDate startDate, LocalDate endDate);
	int countRechargesInPeriod(LocalDate startDate, LocalDate endDate);
	double totalRevenueInPeriod(LocalDate startDate, LocalDate endDate);
	int rechargesCount(Pack pack);
	String expireIfValidityFinished(Account account ,Recharge recharge);
}
