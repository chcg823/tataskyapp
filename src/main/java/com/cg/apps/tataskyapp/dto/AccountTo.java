package com.cg.apps.tataskyapp.dto;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;

import java.time.LocalDate;
import java.util.List;

public class AccountTo {

    private Long id;
    private UserTo userTo;
    private LocalDate registeredDate;
    private List<RechargeDtoForAcc> recharges;
    private List<ServiceRequestTo> requests;
    private Pack currentPack;

    public AccountTo(Account acc) {
        this.id = acc.getAccountId();
        this.currentPack = acc.getCurrentPack();
        this.registeredDate = acc.getRegisteredDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserTo getUserTo() {
        return userTo;
    }

    public void setUserTo(UserTo userTo) {
        this.userTo = userTo;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public List<RechargeDtoForAcc> getRecharges() {
        return recharges;
    }

    public void setRecharges(List<RechargeDtoForAcc> recharges) {
        this.recharges = recharges;
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
