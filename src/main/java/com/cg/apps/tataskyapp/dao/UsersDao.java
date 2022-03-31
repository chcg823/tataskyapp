package com.cg.apps.tataskyapp.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.cg.apps.tataskyapp.entities.Users;

@Repository
public interface UsersDao extends JpaRepository<Users, Integer> {
    @Query(value="select urs from Users urs where urs.id=?1")
    public Optional<Users> findById(int id);

    @Query(value="select urs from Users urs where urs.username=?1")


    public Optional<Users> findByUsername(String username);

    @Query(value="select urs from Users urs where urs.id=?1")
    public List<Users> findByUserId(int id);

}