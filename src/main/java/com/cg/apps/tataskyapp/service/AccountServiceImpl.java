package com.cg.apps.tataskyapp.service;

import com.cg.apps.tataskyapp.dao.AccountDao;
import com.cg.apps.tataskyapp.dto.AccountTo;
import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;
import com.cg.apps.tataskyapp.utils.AccountAlreadyExistException;
import com.cg.apps.tataskyapp.utils.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accDao;

    @Override
    public Account add(Account acc) {
        if(accDao.existsById(acc.getAccountId()))
            throw new AccountAlreadyExistException();
        accDao.save(acc);
        return acc;
    }

    @Override
    public Account findByAccountId(Long accountId) {
        if(!accDao.existsById(accountId))
            throw new AccountNotFoundException();
        Account acc = accDao.getOne(accountId);
        return acc;
    }

    @Override
    public Account update(Account account) {
        Account acc = new Account(account);
        accDao.save(acc);
        return acc;
    }

    @Override
    public void deleteByAccountId(Long accountId) {
        if(!accDao.existsById(accountId))
            throw new AccountNotFoundException();
        accDao.delete(accDao.getAccById(accountId));
    }

    @Override
    public int countCreatedAccountsInPeriod(LocalDate startDate, LocalDate endDate) {
        int c = accDao.countCreatedAccountsInPeriod(startDate, endDate);
        return c;
    }

    @Override
    public int countCreatedAccounts(LocalDate startDate, LocalDate endDate) {
        int c = accDao.countCreatedAccountsInPeriod(startDate, endDate);
        return c;
    }

    @Override
    public int countAccounts() {
        int count = accDao.findAll().size();
        return count;
    }

    @Override
    public void removePackFromAccount(Account account, Pack pack) {
        Account acc = new Account(account);
        acc.setCurrentPack(null);
        update(account);
    }
}
