package com.cg.apps.tataskyapp.controller;

import com.cg.apps.tataskyapp.dao.AccountDao;
import com.cg.apps.tataskyapp.dto.AccountDisplayDto;
import com.cg.apps.tataskyapp.dto.AccountDto;
import com.cg.apps.tataskyapp.dto.RechargeDtoForAcc;
import com.cg.apps.tataskyapp.dto.ServiceRequestDtoForAcc;
import com.cg.apps.tataskyapp.entities.*;
import com.cg.apps.tataskyapp.service.AccountService;
import com.cg.apps.tataskyapp.service.PackService;
import com.cg.apps.tataskyapp.service.UsersService;
import com.cg.apps.tataskyapp.utils.AccountNotFoundException;
import com.cg.apps.tataskyapp.utils.AccountWithUserExistException;
import com.cg.apps.tataskyapp.utils.PackNotFoundException;
import com.cg.apps.tataskyapp.utils.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountDao accountDao;

    @Autowired
    UsersService usersService;

    @Autowired
    PackService packService;

    @PostMapping("/add")
    public ResponseEntity<AccountDisplayDto> addAccount(@RequestBody AccountDto accountDto) {
        Users user = usersService.findUsersById(accountDto.getUserId());
        if (user == null)
            throw new UserNotFoundException();
        if(user.getAccount()!=null)
            throw new AccountWithUserExistException();
        Account newAccount = new Account();
        newAccount.setAccountId(accountDto.getId());
        newAccount.setRegisteredDate(accountDto.getRegisteredDate());
        user.setAccount(newAccount);
        newAccount.setUsers(user);
        accountService.add(newAccount);
        AccountDisplayDto accountDisplayDto = new AccountDisplayDto(newAccount);

        return new ResponseEntity<>(accountDisplayDto, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AccountDisplayDto> findAccountById(@PathVariable Long id) {
        Account account = accountService.findByAccountId(id);
        AccountDisplayDto accountDisplayDto = new AccountDisplayDto(account);
        List<RechargeDtoForAcc> rechargeDtoForAccList = new ArrayList<>();
        for (Recharge recharge : account.getRecharges())
            rechargeDtoForAccList.add(new RechargeDtoForAcc(recharge));
        List<ServiceRequestDtoForAcc> serviceRequestDtoForAccList = new ArrayList<>();
        for(ServiceRequest serviceRequest: account.getRequests())
            serviceRequestDtoForAccList.add(new ServiceRequestDtoForAcc(serviceRequest));
        accountDisplayDto.setRechargeDtoForAccList(rechargeDtoForAccList);
        accountDisplayDto.setServiceRequestList(serviceRequestDtoForAccList);
        return new ResponseEntity<>(accountDisplayDto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<AccountDisplayDto> updateAccount(@RequestBody AccountDto accountDto) {
        Account acc = accountService.findByAccountId(accountDto.getId());
        if (acc == null)
            throw new AccountNotFoundException();
        Users user = usersService.findUsersById(accountDto.getUserId());
        if(user==null)
            throw new UserNotFoundException();
        acc.setAccountId(accountDto.getId());
        acc.setRegisteredDate(accountDto.getRegisteredDate());
        acc.setUsers(user);
        AccountDisplayDto accountDisplayDto = new AccountDisplayDto(acc);
        List<RechargeDtoForAcc> rechargeDtoForAccList = new ArrayList<>();
        for (Recharge recharge : acc.getRecharges())
            rechargeDtoForAccList.add(new RechargeDtoForAcc(recharge));
        accountDisplayDto.setRechargeDtoForAccList(rechargeDtoForAccList);
        accountService.update(acc);
        return new ResponseEntity<>(accountDisplayDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{accountId}")
    public ResponseEntity<String> deleteAccountById(@PathVariable Long accountId) {
        accountService.deleteByAccountId(accountId);
        String message = "Account deleted";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/count/accounts/{startDate}/{endDate}")
    public ResponseEntity<String> countCreatedAccountsInPeriod(@PathVariable String startDate, @PathVariable String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate startLDate = LocalDate.parse(startDate, formatter);
        LocalDate endLDate = LocalDate.parse(endDate, formatter);
        int count = accountService.countCreatedAccountsInPeriod(startLDate, endLDate);
        String message = "Total no. of accounts created between period " + startDate + " and " + endDate + " is " + count;
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/count/accounts")
    public ResponseEntity<String> countAccount() {
        int count = accountService.countAccounts();
        String message = "Total no. of accounts: " + count;
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/remove-pack/{accountId}/{packId}")
    public ResponseEntity<String> removePackForAccount(@PathVariable Long accountId, @PathVariable Long packId) {
        Account account = accountService.findByAccountId(accountId);
        if(account==null)
            throw new AccountNotFoundException();
        Pack pack = packService.findPackById(packId);
        if(pack==null)
            throw new PackNotFoundException();
        accountService.removePackFromAccount(account, pack);
        return new ResponseEntity<>("pack removed", HttpStatus.OK);
    }

    @GetMapping("/greet")
    public ResponseEntity<String> sayHello() {
        String message = "Welcome";
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Tata Sky App");
        return new ResponseEntity<>(message, header, HttpStatus.OK);
    }

}
