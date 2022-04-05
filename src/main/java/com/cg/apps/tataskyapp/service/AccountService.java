package com.cg.apps.tataskyapp.service;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface AccountService {

    Account add(Account account);

    Account update(Account account);

    void deleteByAccountId(Long accountId);

    int countCreatedAccountsInPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    int countCreatedAccounts(LocalDate startDate, LocalDate endDate);

    int countAccounts();

    void removePackFromAccount(Account account, Pack pack);

    Account findByAccountId(Long accountId);


}
