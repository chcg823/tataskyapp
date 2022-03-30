package com.cg.apps.tataskyapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
	public Account add(Account acc) {
		Account newAcc = new Account(acc);
		accDao.save(newAcc);
		return newAcc;
	}
	
	@Override
	public List<Account> getAccounts() {
		return accDao.findAll();
	}
	@Override
	public void deleteByAccountId(Long accountId) {
		accDao.deleteById(accountId);
	}
	@Override
	public Account findByAccountId(Long accountId) {
		Optional<Account> opt = accDao.findById(accountId); 
		Account acc = opt.get();
		return acc;
	}
	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countAccounts() {
		int count = accDao.findAll().size();
		return count;
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
		Account acc = new Account(account);
		acc.setCurrentPack(null);
		update(account);
	}
}
