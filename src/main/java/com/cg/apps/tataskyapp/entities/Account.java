package com.cg.apps.tataskyapp.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Users users;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Recharge> recharges;

	@ManyToOne
	@JoinColumn(name = "account_pack")
	private Pack currentPack;
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<ServiceRequest> requests = new ArrayList<>();
<<<<<<< HEAD
	
=======

>>>>>>> e98ae6efa84478428455125e01b66e8a03f89824
	@Column
	private LocalDate registeredDate;

	public Account() {

	}

	public Account(Long accountId, Users users, List<Recharge> recharges, Pack pack, List<ServiceRequest> requests,
			LocalDate registeredDate) {
		this.accountId = accountId;
		this.users = users;
		this.recharges = recharges;
<<<<<<< HEAD
		this.pack = pack;
=======
		this.currentPack = pack;
>>>>>>> e98ae6efa84478428455125e01b66e8a03f89824
		this.requests = requests;
		this.registeredDate = registeredDate;
	}
	
	public Account(Account acc) {
		this.accountId = acc.accountId;
		this.users =acc.users;
		this.recharges = acc.recharges;
		this.currentPack = acc.currentPack;
		this.requests = acc.requests;
		this.registeredDate = acc.registeredDate;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Recharge> getRecharges() {
		return recharges;
	}

	public void setRecharges(List<Recharge> recharges) {
		this.recharges = recharges;
	}

<<<<<<< HEAD
	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

=======
>>>>>>> e98ae6efa84478428455125e01b66e8a03f89824
	public void addRecharge(Recharge recharge) {
		recharges.add(recharge);
	}

<<<<<<< HEAD
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

=======
>>>>>>> e98ae6efa84478428455125e01b66e8a03f89824
	public List<ServiceRequest> getRequests() {
		return requests;
	}

	public void setRequests(List<ServiceRequest> requests) {
		this.requests = requests;
	}

	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", users=" + users + ", recharges=" + recharges + ", currentPack="
				+ currentPack + ", requests=" + requests + ", registeredDate=" + registeredDate + "]";
	}
	
	
}
