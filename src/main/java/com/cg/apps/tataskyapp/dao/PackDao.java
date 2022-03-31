package com.cg.apps.tataskyapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.tataskyapp.entities.Pack;

@Repository
public interface PackDao extends JpaRepository<Pack, Long>{

}
