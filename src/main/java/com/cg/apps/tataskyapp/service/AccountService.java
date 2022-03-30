package com.cg.apps.tataskyapp.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;

public interface AccountService {

	void addAccount(Account acc);

	List<Account> getAccounts();

	
}
