package com.cg.apps.tataskyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.tataskyapp.entities.ServiceRequest;
import com.cg.apps.tataskyapp.service.ServiceRequestService;

@RestController
@RequestMapping("/servicerequest")
public class ServiceRequestController {
	@Autowired
	ServiceRequestService srService;
	
	@PostMapping
	public String addUser(@RequestBody ServiceRequest sr) {
		srService.addServiceRequest(sr);
		return "User added";
	}
	
}
