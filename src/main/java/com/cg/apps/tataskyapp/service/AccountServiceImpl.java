package com.cg.apps.tataskyapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.tataskyapp.dao.AccountDao;
import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDao accDao;
	
	@Override
	public void addAccount(Account acc) {
		// TODO Auto-generated method stub
		accDao.save(acc);
	}
	@Override
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteByAccountId(Long accountId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Account findById(Long accountId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countAccounts() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int countCreatedAccounts(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int countCreatedAccountsInPeriod(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void removePackFromAccount(Account account, Pack pack) {
		// TODO Auto-generated method stub
		
	}
}
