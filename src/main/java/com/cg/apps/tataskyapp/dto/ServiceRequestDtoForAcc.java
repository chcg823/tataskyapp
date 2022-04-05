package com.cg.apps.tataskyapp.dto;

import com.cg.apps.tataskyapp.entities.ServiceRequest;

import java.time.LocalDate;

public class ServiceRequestDtoForAcc {

    private Long id;
    private LocalDate requestDate;
    private String message;
    private Boolean statusOpened;

    public ServiceRequestDtoForAcc() {

    }

    public ServiceRequestDtoForAcc(ServiceRequest serviceRequest) {
        this.id = serviceRequest.getId();
        this.requestDate = serviceRequest.getRequestDate();
        this.message = serviceRequest.getMessage();
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
