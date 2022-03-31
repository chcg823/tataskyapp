package com.cg.apps.tataskyapp.dto;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;

import java.time.LocalDate;
import java.util.List;

public class AccountToForRecharge {

    private Long id;
    private UserToRecharge userToRecharge;
    private LocalDate registeredDate;
    private List<ServiceRequestTo> requets;
    private Pack currentPack;

    public AccountToForRecharge(Account acc) {
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

    public UserToRecharge getUserToRecharge() {
        return userToRecharge;
    }

    public void setUserToRecharge(UserToRecharge userToRecharge) {
        this.userToRecharge = userToRecharge;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public List<ServiceRequestTo> getRequets() {
        return requets;
    }

    public void setRequets(List<ServiceRequestTo> requets) {
        this.requets = requets;
    }

    public Pack getCurrentPack() {
        return currentPack;
    }

    public void setCurrentPack(Pack currentPack) {
        this.currentPack = currentPack;
    }
}
