package com.cg.apps.tataskyapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ServiceRequestDto {
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate requestDate;
    private Boolean statusOpened;
    private Long account_id;

    public ServiceRequestDto() {
    }

    public ServiceRequestDto(LocalDate requestDate, Boolean statusOpened, Long account_id) {
        this.requestDate = requestDate;
        this.statusOpened = statusOpened;
        this.account_id = account_id;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public Boolean getStatusOpened() {
        return statusOpened;
    }

    public void setStatusOpened(Boolean statusOpened) {
        this.statusOpened = statusOpened;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }
}