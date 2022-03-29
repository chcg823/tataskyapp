package com.cg.apps.tataskyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping
	public String addAccount(@RequestBody Account account) {
		accountService.addAccount(account);
		return "Added account";
	}
	
}
