package com.cg.apps.tataskyapp.dto;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;
import com.cg.apps.tataskyapp.entities.ServiceRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountDtoForRecharge {

    private Long id;
    private LocalDate registeredDate;
    private Pack pack;
    private List<ServiceRequestDtoForAcc> serviceRequestDtoForAccList;

    public AccountDtoForRecharge() {

    }

    public AccountDtoForRecharge(Account account) {
        this.id = account.getAccountId();
        this.registeredDate = account.getRegisteredDate();
        this.pack = account.getCurrentPack();
        List<ServiceRequestDtoForAcc> serviceRequestDtoForAccs = new ArrayList<>();
        for (ServiceRequest serviceRequest : account.getRequests())
            serviceRequestDtoForAccs.add(new ServiceRequestDtoForAcc(serviceRequest));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public List<ServiceRequestDtoForAcc> getServiceRequestDtoForAccList() {
        return serviceRequestDtoForAccList;
    }

    public void setServiceRequestDtoForAccList(List<ServiceRequestDtoForAcc> serviceRequestDtoForAccList) {
        this.serviceRequestDtoForAccList = serviceRequestDtoForAccList;
    }
}
