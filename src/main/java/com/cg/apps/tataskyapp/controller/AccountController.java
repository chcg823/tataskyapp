package com.cg.apps.tataskyapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping("/add")
	public ResponseEntity<String> addAccount(@RequestBody Account account) {
		Account newAcc = accountService.add(account);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "add Account");
		String message = "Account added";
		return new ResponseEntity<String>(message, header, HttpStatus.OK);
	}

	@GetMapping("/find-account/{accountId}")
	public ResponseEntity<String> deleteAccountById(@PathVariable Long accountId) {
		accountService.deleteByAccountId(accountId);
		HttpHeaders header = new HttpHeaders();
		header.add("desc","delete account by id");
		String message = "Account deleted";
		return new ResponseEntity<String>(message, header, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateAccount(@RequestBody Account account) {
		accountService.update(account);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "update account");
		String message = "Account updated";
		return new ResponseEntity<String>(message, header, HttpStatus.OK);
	}

	@GetMapping("/greet")
	public ResponseEntity<String> sayHello() {
		String message = "Welcome";
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Tata Sky App");
		return new ResponseEntity<String>(message, header, HttpStatus.OK);
	}

}
