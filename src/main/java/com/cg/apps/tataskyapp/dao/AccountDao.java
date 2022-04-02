package com.cg.apps.tataskyapp.dao;

import com.cg.apps.tataskyapp.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
    @Query("select count(a.accountId) from Account a where a.registeredDate between :startDate and :endDate")
    int countCreatedAccountsInPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "select acc from Account acc where acc.accountId=?1")
    Account getAccById(long accountId);
}
