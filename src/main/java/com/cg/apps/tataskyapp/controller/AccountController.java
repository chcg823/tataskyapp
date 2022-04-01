package com.cg.apps.tataskyapp.controller;

import com.cg.apps.tataskyapp.dao.AccountDao;
import com.cg.apps.tataskyapp.dao.UsersDao;
import com.cg.apps.tataskyapp.dto.*;
import com.cg.apps.tataskyapp.entities.*;
import com.cg.apps.tataskyapp.service.AccountService;
import com.cg.apps.tataskyapp.service.PackService;
import com.cg.apps.tataskyapp.service.UsersService;
import com.cg.apps.tataskyapp.utils.AccountNotFoundException;
import com.cg.apps.tataskyapp.utils.PackNotFoundException;
import com.cg.apps.tataskyapp.utils.UserNotFoundException;
import org.apache.catalina.User;
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
    public ResponseEntity<Account> addAccount(@RequestBody AccountDto accountDto) {
        Users user = usersService.findUsersById(accountDto.getUserId());
        if(user==null)
            throw new UserNotFoundException();
        Account newAccount = new Account();
        newAccount.setAccountId(accountDto.getId());
        newAccount.setRegisteredDate(accountDto.getRegisteredDate());
        user.setAccount(newAccount);
        newAccount.setUsers(user);
        accountService.add(newAccount);
        return new ResponseEntity<>(newAccount, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Account> findAccountById(@PathVariable Long id) {
        Account acc = accountService.findByAccountId(id);
        return ResponseEntity.status(HttpStatus.OK).body(acc);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAccount(@RequestBody AccountDto accountDto) {
        Account acc = accountService.findByAccountId(accountDto.getId());
        if(acc==null)
            addAccount(accountDto);
        Users user = usersService.findUsersById(accountDto.getUserId());
        acc.setAccountId(accountDto.getId());
        acc.setRegisteredDate(accountDto.getRegisteredDate());
        acc.setUsers(user);
        Pack pack =  packService.findPackById(accountDto.getPackId());
        acc.setCurrentPack(pack);
        accountService.update(acc);
        return new ResponseEntity<>(acc.toString(), HttpStatus.OK);
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

    @PostMapping("/remove-pack")
    public ResponseEntity<String> removePackForAccount(Long accoundId, Long packId) {
        Account acc = accountService.findByAccountId(accoundId);
        if(acc.getCurrentPack().getId()!=packId)
            throw new PackNotFoundException();
        accountService.removePackFromAccount(acc, acc.getCurrentPack());
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
