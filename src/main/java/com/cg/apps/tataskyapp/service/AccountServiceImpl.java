package com.cg.apps.tataskyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.tataskyapp.dao.AccountDao;
import com.cg.apps.tataskyapp.entities.Account;

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
}
