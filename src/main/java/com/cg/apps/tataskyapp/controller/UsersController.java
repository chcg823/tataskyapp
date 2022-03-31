package com.cg.apps.tataskyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.tataskyapp.entities.Users;
import com.cg.apps.tataskyapp.service.UsersService;

@RestController
@RequestMapping("/user")
public class UsersController {
	@Autowired
	UsersService userService;
	
	@PostMapping
	public String addUser(@RequestBody Users user) {
		userService.addUser(user);
		return "User added";
	}
	
}
