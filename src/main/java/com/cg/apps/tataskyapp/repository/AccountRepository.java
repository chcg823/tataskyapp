package com.cg.apps.tataskyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.tataskyapp.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
