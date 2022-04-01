package com.cg.apps.tataskyapp.dto;

import java.time.LocalDate;
import java.util.List;

public class RechargeDto {

	private long rechargeId;
	private long accountId;
	private long packId;
	private double amount;
	private int daysValidity;
	private String planDescription;
	private String planName;
	private LocalDate purchasedDate;
	private List<String> channels;
	private boolean active;

	public RechargeDto() {

	}

	public RechargeDto(long rechargeId, long accountId, long packId, double amount, int daysValidity,
					   String planDescription, String planName, LocalDate purchasedDate, List<String> channels, boolean active) {
		this.rechargeId = rechargeId;
		this.accountId = accountId;
		this.packId = packId;
		this.amount = amount;
		this.daysValidity = daysValidity;
		this.planDescription = planDescription;
		this.planName = planName;
		this.purchasedDate = purchasedDate;
		this.channels = channels;
		this.active = active;
	}

	public long getRechargeId() {
		return rechargeId;
	}

	public void setRechargeId(long rechargeId) {
		this.rechargeId = rechargeId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getPackId() {
		return packId;
	}

	public void setPackId(long packId) {
		this.packId = packId;
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