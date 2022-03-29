package com.cg.apps.tataskyapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.tataskyapp.entities.Recharge;

@Repository
public interface RechargeDao extends JpaRepository<Recharge, Integer>{

}
