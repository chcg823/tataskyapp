package com.cg.apps.tataskyapp.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;

public interface AccountService {

	Account add(Account acc);
	
	Account update(Account account);
	
	void deleteByAccountId(Long accountId);
	
	int countCreatedAccountsInPeriod(LocalDate startDate, LocalDate endDate);
	
	int countCreatedAccounts(LocalDate startDate, LocalDate endDate);
	
	int countAccounts();
	
	void removePackFromAccount(Account account, Pack pack);
	
	List<Account> getAccounts();

	Account findByAccountId(Long accountId);
	
	

	
}
