package com.cg.apps.tataskyapp.accountms.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.apps.tataskyapp.packms.entity.Pack;
import com.cg.apps.tataskyapp.rechargems.entity.Recharge;
import com.cg.apps.tataskyapp.servicerequestms.entity.ServiceRequest;
import com.cg.apps.tataskyapp.userms.entity.User;

@Entity
@Table(name = "account")
public class Account {
	@Id
	private Long accountId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private User user;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Recharge> recharges;

	@Column
	private LocalDate registeredDate;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<ServiceRequest> requests;

	@ManyToOne
	@JoinColumn(name = "id")
	private Pack currentPack;

	public Account() {

	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Recharge> getRecharges() {
		return recharges;
	}

	public void setRecharges(List<Recharge> recharges) {
		this.recharges = recharges;
	}

	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}

	public List<ServiceRequest> getRequests() {
		return requests;
	}

	public void setRequests(List<ServiceRequest> requests) {
		this.requests = requests;
	}

	public Pack getCurrentPack() {
		return currentPack;
	}

	public void setCurrentPack(Pack currentPack) {
		this.currentPack = currentPack;
	}

	public Account(Long accountId, User user, List<Recharge> recharges, LocalDate registeredDate,
			List<ServiceRequest> requests, Pack currentPack) {
		super();
		this.accountId = accountId;
		this.user = user;
		this.recharges = recharges;
		this.registeredDate = registeredDate;
		this.requests = requests;
		this.currentPack = currentPack;
	}

}
