package com.cg.apps.tataskyapp.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "servicerequest")
public class ServiceRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "requestDate")
	private LocalDate requestDate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Account account;
	@Column(name = "message", length = 30)
	private String message;
	@Column(name = "status")
	private Boolean statusOpened;

	public ServiceRequest() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatusOpened() {
		return statusOpened;
	}

	public void setStatusOpened(Boolean statusOpened) {
		this.statusOpened = statusOpened;
	}

	public ServiceRequest(Long id, LocalDate requestDate, Account account, String message, Boolean statusOpened) {
		super();
		this.id = id;
		this.requestDate = requestDate;
		this.account = account;
		this.message = message;
		this.statusOpened = statusOpened;
	}

}
