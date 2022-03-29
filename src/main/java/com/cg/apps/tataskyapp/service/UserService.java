package com.cg.apps.tataskyapp.service;

import java.util.List;

import com.cg.apps.tataskyapp.entities.User;

public interface UserService {
	
	void addUser(User user);
	List<User> getUsers();
	
}
