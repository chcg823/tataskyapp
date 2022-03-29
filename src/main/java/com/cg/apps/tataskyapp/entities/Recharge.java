package com.cg.apps.tataskyapp.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recharge")
public class Recharge {
	@Id
	private int id;
//
	@ManyToOne(cascade = CascadeType.ALL)
	private Account account;
	@Column(length = 10)
	private Double amount;
	@Column(length = 10)
	private LocalDate purchasedDate;
//	@Column
//    private Pack pack;

	private boolean active;

	public Recharge() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(LocalDate purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Recharge(int id, Account account, Double amount, LocalDate purchasedDate, boolean active) {
		super();
		this.id = id;
		this.account = account;
		this.amount = amount;
		this.purchasedDate = purchasedDate;
		this.active = active;
	}

}
