package com.cg.apps.tataskyapp.accountms.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.apps.tataskyapp.userms.entity.User;

@Entity
@Table(name = "accountTab")
public class Account {

	@Id
	private Long accountId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private User user;

//	@OneToMany(mappedBy="account", cascade = CascadeType.ALL)
//    private List<Recharge>recharges;

	@Column
	private LocalDate registeredDate;

	public Account(Long accountId, User user, LocalDate registeredDate) {
		super();
		this.accountId = accountId;
		this.user = user;
		this.registeredDate = registeredDate;
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

	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}

//	@OneToMany(mappedBy="account", cascade = CascadeType.ALL)
//    private List<ServiceRequest>requests;

//	@ManyToOne
//	@JoinColumn(name="id")
//    private Pack currentPack;

}
