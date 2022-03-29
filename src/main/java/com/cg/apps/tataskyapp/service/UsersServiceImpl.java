package com.cg.apps.tataskyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.apps.tataskyapp.dao.UsersDao;
import com.cg.apps.tataskyapp.entities.Users;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	UsersDao usersDao;
	
	@Override
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		usersDao.save(user);
		
	}
	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
