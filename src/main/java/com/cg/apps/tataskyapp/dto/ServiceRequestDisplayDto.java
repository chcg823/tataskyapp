package com.cg.apps.tataskyapp.dto;

import com.cg.apps.tataskyapp.entities.ServiceRequest;

import java.time.LocalDate;

public class ServiceRequestDisplayDto {

    private Long id;
    private LocalDate requestDate;
    private AccountDtoForServiceRequest account;
    private String message;
    private Boolean statusOpened;

    public ServiceRequestDisplayDto() {

    }

    public ServiceRequestDisplayDto(ServiceRequest serviceRequest) {
        this.id = serviceRequest.getId();
        this.message = serviceRequest.getMessage();
        this.requestDate = serviceRequest.getRequestDate();
        this.account = new AccountDtoForServiceRequest(serviceRequest.getAccount());
        this.statusOpened = serviceRequest.getStatusOpened();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public AccountDtoForServiceRequest getAccount() {
        return account;
    }

    public void setAccount(AccountDtoForServiceRequest account) {
        this.account = account;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatusOpened() {
        return statusOpened;
    }

    public void setStatusOpened(Boolean statusOpened) {
        this.statusOpened = statusOpened;
    }
}
