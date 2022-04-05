package com.cg.apps.tataskyapp.dao;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;
import com.cg.apps.tataskyapp.entities.Recharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RechargeDao extends JpaRepository<Recharge, Long> {

    @Query(value = "select r from Recharge r where r.account=?1 ORDER BY r.purchasedDate DESC")
    List<Recharge> findRechargesForUserInDescendingOrderByPurchasedDate(Account account);

    @Query(value = "select count(*) from Recharge r where r.account=?1")
    int rechargesForUserCount(Account account);

    @Query(value = "select r from Recharge  r where r.purchasedDate between :startDate and :endDate")
    List<Recharge> findAllRechargesInPeriod(LocalDate startDate, LocalDate endDate);

    @Query(value = "select count(r.id) from Recharge r where r.purchasedDate between :startDate and :endDate")
    int countRechargesInPeriod(LocalDate startDate, LocalDate endDate);

    @Query(value = "select sum(r.amount) from Recharge r where r.purchasedDate between :startDate and :endDate")
    double totalRevenueInPeriod(LocalDate startDate, LocalDate endDate);

    @Query(value = "select count(r.id) from Recharge r where r.pack = ?1")
    int rechargesCount(Pack pack);
}