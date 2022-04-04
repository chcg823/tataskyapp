package com.cg.apps.tataskyapp.dto;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;
import com.cg.apps.tataskyapp.entities.ServiceRequest;

import java.time.LocalDate;
import java.util.List;

public class AccountDisplayDto {

    private Long accountId;
    private LocalDate registeredDate;
    private UsersDtoForAcc user;
    private List<RechargeDtoForAcc> rechargeDtoForAccList;
    private List<ServiceRequestDtoForAcc> serviceRequestDtoAccList;
    private Pack currentPack;

    public AccountDisplayDto() {

    }

    public AccountDisplayDto(Account account) {
        this.user = new UsersDtoForAcc(account.getUsers());
        this.accountId = account.getAccountId();
        this.registeredDate = account.getRegisteredDate();
        this.currentPack = account.getCurrentPack();
    }

    public List<RechargeDtoForAcc> getRechargeDtoForAccList() {
        return rechargeDtoForAccList;
    }

    public void setRechargeDtoForAccList(List<RechargeDtoForAcc> rechargeDtoForAccList) {
        this.rechargeDtoForAccList = rechargeDtoForAccList;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public UsersDtoForAcc getUsersDisplayDto() {
        return user;
    }

    public void setUsersDisplayDto(UsersDtoForAcc usersDtoForAcc) {
        this.user = usersDtoForAcc;
    }

    public Pack getCurrentPack() {
        return currentPack;
    }

    public void setCurrentPack(Pack currentPack) {
        this.currentPack = currentPack;
    }

    public List<ServiceRequestDtoForAcc> getServiceRequestList() {
        return serviceRequestDtoAccList;
    }

    public void setServiceRequestList(List<ServiceRequestDtoForAcc> serviceRequestList) {
        this.serviceRequestDtoAccList = serviceRequestList;
    }
}
