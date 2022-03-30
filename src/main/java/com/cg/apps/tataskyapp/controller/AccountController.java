package com.cg.apps.tataskyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/find")
	public ResponseEntity<String> findAccountById(@RequestBody Long accountId) {
		Account acc = accountService.findById(accountId);
		String message = acc.toString();
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "find account by Id");
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
