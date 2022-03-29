package com.cg.apps.tataskyapp.rechargems.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cg.apps.tataskyapp.accountms.entity.Account;
import com.cg.apps.tataskyapp.packms.entity.Pack;

@Entity
@Table(name = "recharge")
public class Recharge {
	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name = "accountId")
	private Account account;
	@Column(length = 10)
	private Double amount;
	@Column(length = 10)
	private LocalDate purchasedDate;
	@Column
	private Pack pack;

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

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public Recharge(int id, Account account, Double amount, LocalDate purchasedDate, Pack pack) {
		super();
		this.id = id;
		this.account = account;
		this.amount = amount;
		this.purchasedDate = purchasedDate;
		this.pack = pack;
	}

}
