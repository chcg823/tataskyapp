package com.cg.apps.tataskyapp.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;

import net.bytebuddy.asm.Advice.Local;

public interface AccountService {

	void addAccount(Account acc);

	Account findById(Long accountId);
	
	Account update(Account account);
	
	void deleteByAccountId(Long accountId);
	
	int countCreatedAccountsInPeriod(LocalDate startDate, LocalDate endDate);
	
	int countCreatedAccounts(LocalDate startDate, LocalDate endDate);
	
	int countAccounts();
	
	void removePackFromAccount(Account account, Pack pack);
	
	List<Account> getAccounts();
	
	

	
}
