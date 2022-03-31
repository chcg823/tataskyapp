package com.cg.apps.tataskyapp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "Asia/Calcutta")
    @Column
    private LocalDate registeredDate;

    public Account() {

    }

	public Account(Long accountId, Users users, List<Recharge> recharges, Pack pack, List<ServiceRequest> requests,
			LocalDate registeredDate) {
		this.accountId = accountId;
		this.users = users;
		this.recharges = recharges;
		//this.pack = pack;
		this.currentPack = pack;
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

    public Pack getCurrentPack() {
        return currentPack;
    }

    public void setCurrentPack(Pack currentPack) {
        this.currentPack = currentPack;
    }

    public void copy(Account account) {

        this.accountId = account.getAccountId();
        this.users = account.getUsers();
        this.recharges = account.getRecharges();
        this.registeredDate = account.getRegisteredDate();
        this.requests = account.getRequests();
        this.currentPack = account.getCurrentPack();

    }

    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", users=" + users + ", recharges=" + recharges + ", currentPack="
                + currentPack + ", requests=" + requests + ", registeredDate=" + registeredDate + "]";
    }


}
