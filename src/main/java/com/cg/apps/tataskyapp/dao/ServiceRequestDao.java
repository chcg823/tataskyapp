package com.cg.apps.tataskyapp.dao;

import com.cg.apps.tataskyapp.entities.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRequestDao extends JpaRepository<ServiceRequest, Long> {

}
