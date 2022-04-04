package com.cg.apps.tataskyapp.service;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;
import com.cg.apps.tataskyapp.entities.Recharge;

import java.time.LocalDate;
import java.util.List;

public interface RechargeService {

    Recharge createRecharge(Pack pack, Account account);

    Recharge update(Recharge recharge);

    List<Recharge> findRechargesForUserInDescendingOrderByPurchasedDate(Account account);

    int rechargesForUserCount(Account account);

    List<Recharge> findAllRechargesInPeriod(LocalDate startDate, LocalDate endDate);

    int countRechargesInPeriod(LocalDate startDate, LocalDate endDate);

    double totalRevenueInPeriod(LocalDate startDate, LocalDate endDate);

    int rechargesCount(Pack pack);

    String expireIfValidityFinished(Account account, Recharge recharge);

    Recharge update(Pack pack, Account account, long rechargeId);
}
