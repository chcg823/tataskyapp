package com.cg.apps.tataskyapp.service;

import com.cg.apps.tataskyapp.dao.*;
import com.cg.apps.tataskyapp.dto.ServiceRequestDto;
import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;
import com.cg.apps.tataskyapp.entities.Recharge;
import com.cg.apps.tataskyapp.entities.ServiceRequest;
import com.cg.apps.tataskyapp.utils.AccountAlreadyExistException;
import com.cg.apps.tataskyapp.utils.AccountNotFoundException;
import com.cg.apps.tataskyapp.utils.PackNotFoundException;
import com.cg.apps.tataskyapp.utils.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accDao;

    @Autowired
    PackDao packDao;

    @Autowired
    UsersDao usersDao;

    @Autowired
    RechargeDao rechargeDao;

    @Autowired
    ServiceRequestDao serviceRequestDao;

    @Override
    public Account add(Account acc) {
        if (accDao.existsById(acc.getAccountId()))
            throw new AccountAlreadyExistException();
        accDao.save(acc);
        return acc;
    }

    @Override
    public Account findByAccountId(Long accountId) {
        if (!accDao.existsById(accountId))
            throw new AccountNotFoundException();
        Account acc = accDao.getAccById(accountId);
        return acc;
    }

    @Override
    public Account update(Account account) {
        Account acc = new Account(account);
        if (!usersDao.existsById(account.getUsers().getId()))
            throw new UserNotFoundException();
        accDao.save(account);
        return acc;
    }

    @Override
    public void deleteByAccountId(Long accountId) {
        if (!accDao.existsById(accountId))
            throw new AccountNotFoundException();
        accDao.deleteById(accountId);
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
        if(account.getCurrentPack()!=pack)
            throw new PackNotFoundException();
        account.setCurrentPack(null);
        accDao.save(account);
    }
}
