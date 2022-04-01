package com.cg.apps.tataskyapp.dto;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;

import java.time.LocalDate;
import java.util.List;

public class AccountToUser {

    private Long id;
    private List<RechargeDtoForAcc> recharges;
    private LocalDate registeredDate;
    private List<ServiceRequestTo> requests;
    private Pack currentPack;

    public AccountToUser(Account account) {
        this.id = account.getAccountId();
        this.currentPack = account.getCurrentPack();
        this.registeredDate = account.getRegisteredDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RechargeDtoForAcc> getRecharges() {
        return recharges;
    }

    public void setRecharges(List<RechargeDtoForAcc> recharges) {
        this.recharges = recharges;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public List<ServiceRequestTo> getRequests() {
        return requests;
    }

    public void setRequests(List<ServiceRequestTo> requests) {
        this.requests = requests;
    }

    public Pack getCurrentPack() {
        return currentPack;
    }

    public void setCurrentPack(Pack currentPack) {
        this.currentPack = currentPack;
    }
}
