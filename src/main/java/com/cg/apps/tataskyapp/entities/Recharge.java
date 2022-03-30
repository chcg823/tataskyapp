package com.cg.apps.tataskyapp.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recharge")
public class Recharge {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "accountId")
	private Account account;
	@Column(length = 10)
	private double amount;
	@Column(length = 10)
	private int daysValidity;
	@Column(length = 25)
	private String planDescription;
	@Column(length = 15)
	private String planName;
	@Column
	private LocalDate purchasedDate;
	@ManyToOne(cascade = CascadeType.ALL)
	private Pack pack;
	@ElementCollection
	private List<String> channels;
	private boolean active;

	public Recharge() {

	}

	public Recharge(int id, Account account, double amount, int daysValidity, String planDescription, String planName,
			LocalDate purchasedDate,Pack pack, List<String> channels, boolean active) {
		this.id = id;
		this.account = account;
		this.amount = amount;
		this.daysValidity = daysValidity;
		this.planDescription = planDescription;
		this.planName = planName;
		this.purchasedDate = purchasedDate;
		this.pack = pack;
		this.channels = channels;
		this.active = active;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getDaysValidity() {
		return daysValidity;
	}

	public void setDaysValidity(int daysValidity) {
		this.daysValidity = daysValidity;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
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

	public List<String> getChannels() {
		return channels;
	}

	public void setChannels(List<String> channels) {
		this.channels = channels;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
