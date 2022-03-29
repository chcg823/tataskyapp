package com.cg.apps.tataskyapp.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "service_request")
public class ServiceRequest {
	
	private Long id;
	private LocalDate requestDate;
	private Account account;
	private String message;
	private Boolean statusOpened;
	
	public ServiceRequest() {
		
	}
	
}
