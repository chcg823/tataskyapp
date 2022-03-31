package com.cg.apps.tataskyapp.dto;

import java.time.LocalDate;

public class AccountDto {

    private Long id;
    private LocalDate registeredDate;

    public AccountDto() {

    }

    public AccountDto(Long id, LocalDate registeredDate) {
        this.id = id;
        this.registeredDate = registeredDate;
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
}
