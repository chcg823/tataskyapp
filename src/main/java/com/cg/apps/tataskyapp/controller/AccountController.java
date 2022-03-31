package com.cg.apps.tataskyapp.controller;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.service.AccountService;
import com.cg.apps.tataskyapp.utils.AccountAlreadyExistException;
import com.cg.apps.tataskyapp.utils.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/add")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        Account newAcc = accountService.findByAccountId(account.getAccountId());
		if(newAcc!=null)
			throw new AccountAlreadyExistException();
		newAcc = new Account(account);
		accountService.add(newAcc);
        return new ResponseEntity<>(newAcc, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Account> findAccountById(@PathVariable Long id) {
        Account acc = accountService.findByAccountId(id);
        if (acc == null)
            throw new AccountNotFoundException();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
		Account acc = accountService.findByAccountId(account.getAccountId());
		if(acc==null)
			throw new AccountNotFoundException();
        accountService.update(account);
        return new ResponseEntity<>(acc,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{accountId}")
    public ResponseEntity<String> deleteAccountById(@PathVariable Long accountId) {
        accountService.deleteByAccountId(accountId);
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "delete account by id");
        String message = "Account deleted";
        return new ResponseEntity<String>(message, header, HttpStatus.OK);
    }


    @GetMapping("/greet")
    public ResponseEntity<String> sayHello() {
        String message = "Welcome";
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Tata Sky App");
        return new ResponseEntity<String>(message, header, HttpStatus.OK);
    }

    @GetMapping("/count/accounts")
    public ResponseEntity<String> countAccount() {
        int count = accountService.countAccounts();
        String message = "Total no. of accounts: " + count;
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @PostMapping("/count/accounts/{startDate}/{endDate}")
    public ResponseEntity<String> countCreatedAccountsInPeriod(@PathVariable String startDate, @PathVariable String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate startLDate = LocalDate.parse(startDate, formatter);
        LocalDate endLDate = LocalDate.parse(endDate, formatter);
        int count = accountService.countCreatedAccountsInPeriod(startLDate, endLDate);
        String message = "Total no. of accounts created between period " + startDate + " and " + endDate + " is " + count;
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

}
