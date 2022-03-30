package com.cg.apps.tataskyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.service.AccountService;

@RestController
@RequestMapping("/find-account")
public class FindAccountController {
	
	@Autowired
	AccountService accService;
	
	@PostMapping
	public String findAccount(@RequestBody Long accId) {
		accService.findById(accId);
		return "Account Found";
	}
	
}
