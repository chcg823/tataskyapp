package com.cg.apps.tataskyapp.dao;


import com.cg.apps.tataskyapp.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersDao extends JpaRepository<Users, Long> {
//    @Query(value="select urs from Users urs where urs.id=?1")
//    public Optional<Users> findById(int id);

    @Query(value = "select urs from Users urs where urs.username=?1")
    Optional<Users> findByUsername(String username);

    @Query(value = "select urs from Users urs where urs.id= ?1")
    List<Users> findByUserId(Long id);

}