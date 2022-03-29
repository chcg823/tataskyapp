package com.cg.apps.tataskyapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.tataskyapp.entities.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer>{
	
}
