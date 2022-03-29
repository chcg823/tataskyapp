package com.cg.apps.tataskyapp.packms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cg.apps.tataskyapp.accountms.entity.Account;

@Entity
@Table(name = "pack")
public class Pack {
	@Id
	private Long id;
	@Column(length = 15)
	private Double cost;
	@Column(length = 15)
	private Integer daysValidity;
	@Column(length = 15)
	private String description;
	@Column(length = 15)
	private String planName;
	@Column(length = 15)
	private List<String> channels;

	@OneToMany(mappedBy = "pack", cascade = CascadeType.ALL)
	List<Account> accounts;

	public Pack() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getDaysValidity() {
		return daysValidity;
	}

	public void setDaysValidity(Integer daysValidity) {
		this.daysValidity = daysValidity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public List<String> getChannels() {
		return channels;
	}

	public void setChannels(List<String> channels) {
		this.channels = channels;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Pack(Long id, Double cost, Integer daysValidity, String description, String planName, List<String> channels,
			List<Account> accounts) {
		super();
		this.id = id;
		this.cost = cost;
		this.daysValidity = daysValidity;
		this.description = description;
		this.planName = planName;
		this.channels = channels;
		this.accounts = accounts;
	}

}
