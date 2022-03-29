package com.cg.apps.tataskyapp.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "accountTab")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id")
//	private User user;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Recharge> recharges;

	//@ManyToOne(cascade = CascadeType.ALL)
	private Pack pack;
	
	@Column
	private LocalDate registeredDate;

	public Account() {

	}

	public Account(Long accountId, List<Recharge> recharges, LocalDate registeredDate) {
		super();
		this.accountId = accountId;
		this.recharges = recharges;
		this.registeredDate = registeredDate;
	}

	public List<Recharge> getRecharges() {
		return recharges;
	}

	public void setRecharges(List<Recharge> recharges) {
		this.recharges = recharges;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	public void addRecharge(Recharge recharge) {
		recharges.add(recharge);
	}
	
	
	
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

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
