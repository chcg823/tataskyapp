package com.cg.apps.tataskyapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.tataskyapp.dao.ServiceRequestDao;
import com.cg.apps.tataskyapp.entities.ServiceRequest;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService{

	@Autowired
	ServiceRequestDao srDao;
	
	@Override
	public void addServiceRequest(ServiceRequest sr) {
		// TODO Auto-generated method stub
		srDao.save(sr);
	}
	
}
