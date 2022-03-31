package com.cg.apps.tataskyapp.service;

import java.util.List;

import com.cg.apps.tataskyapp.entities.Users;

public interface UsersService {
	
	void addUser(Users user);
	List<Users> getUsers();
	
}
