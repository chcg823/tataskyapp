package com.cg.apps.tataskyapp.service;

import com.cg.apps.tataskyapp.dao.RechargeDao;
import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;
import com.cg.apps.tataskyapp.entities.Recharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RechargeServiceImpl implements RechargeService {

    @Autowired
    RechargeDao rechargeDao;

    @Autowired
    AccountService accountService;

//    @Autowired
//    RechargeService rechargeService;

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
        recharge.setPack(pack);
        account.setCurrentPack(pack);
        account.getRecharges().add(recharge);
        accountService.update(account);
        return recharge;
        //return rechargeDao.save(recharge);
    }

    @Override
    public Recharge update(Recharge recharge) {
        return null;
    }

    @Override
    public Recharge update(Pack pack, Account account, long rechargeId) {
        Recharge rechargeUpdated = rechargeDao.findById(rechargeId).orElse(null);
        rechargeUpdated.setAccount(account);
        rechargeUpdated.setPack(pack);
        rechargeUpdated.setAmount(pack.getCost());
        rechargeUpdated.setDaysValidity(pack.getDaysValidity());
        rechargeUpdated.setPlanDescription(pack.getDescription());
        rechargeUpdated.setPlanName(pack.getPlanName());
        rechargeUpdated.setActive(true);
        LocalDate date = LocalDate.now();
        rechargeUpdated.setPurchasedDate(date);
        return rechargeDao.save(rechargeUpdated);
    }

    @Override
    public List<Recharge> findRechargesForUserInDescendingOrderByPurchasedDate(Account account) {
        return rechargeDao.findRechargesForUserInDescendingOrderByPurchasedDate(account);
    }

    @Override
    public int rechargesForUserCount(Account account) {
        return rechargeDao.rechargesForUserCount(account);
    }

    @Override
    public List<Recharge> findAllRechargesInPeriod(LocalDate startDate, LocalDate endDate) {
        return rechargeDao.findAllRechargesInPeriod(startDate, endDate);
    }

    @Override
    public int countRechargesInPeriod(LocalDate startDate, LocalDate endDate) {
        return rechargeDao.countRechargesInPeriod(startDate, endDate);
    }

    @Override
    public double totalRevenueInPeriod(LocalDate startDate, LocalDate endDate) {
        return rechargeDao.totalRevenueInPeriod(startDate, endDate);
    }

    @Override
    public int rechargesCount(Pack pack) {
        return rechargeDao.rechargesCount(pack);
    }

    @Override
    public String expireIfValidityFinished(Account account, Recharge recharge) {
        LocalDate date = LocalDate.now();
        LocalDate rechargeDate = recharge.getPurchasedDate();
        LocalDate validDate = rechargeDate.plusDays(recharge.getDaysValidity());
        if (validDate.isBefore(date)) {
            recharge.setActive(false);
            account.setCurrentPack(null);
            return "Validity Expired";
        } else {
            return "Validity not Expired";
        }
    }
}