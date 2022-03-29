package com.cg.apps.tataskyapp.service;

import java.util.List;

import com.cg.apps.tataskyapp.entities.Account;

public interface AccountService {
	
	void addAccount(Account acc);
	List<Account> getAccounts();
	
}
