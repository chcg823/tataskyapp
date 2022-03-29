package com.cg.apps.tataskyapp.servicerequestms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cg.apps.tataskyapp.accountms.entity.Account;

@Entity
@Table(name = "servicerequest")
public class ServiceRequest {
	@Id
	private Long id;
	@Column
	private LocalDate requestedDate;
	@ManyToOne
	@JoinColumn(name = "accountId")
	private Account account;
	@Column(length = 10)
	private String message;

	public ServiceRequest() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(LocalDate requestedDate) {
		this.requestedDate = requestedDate;
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

	public ServiceRequest(Long id, LocalDate requestedDate, Account account, String message) {
		super();
		this.id = id;
		this.requestedDate = requestedDate;
		this.account = account;
		this.message = message;
	}

}
