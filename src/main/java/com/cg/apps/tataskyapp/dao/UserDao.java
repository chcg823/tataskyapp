package com.cg.apps.tataskyapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.tataskyapp.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

}
