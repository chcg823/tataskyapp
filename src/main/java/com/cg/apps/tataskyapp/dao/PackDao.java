package com.cg.apps.tataskyapp.dao;

import com.cg.apps.tataskyapp.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackDao extends JpaRepository<Pack, Long> {

}
