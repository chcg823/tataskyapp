package com.cg.apps.tataskyapp.dto;

import com.cg.apps.tataskyapp.entities.Users;

import java.time.LocalDate;

public class AccountDto {

    public Long id;
    public Users user;
    public LocalDate registredDate;

    public AccountDto() {

    }

    public AccountDto(Long id, Users user, LocalDate registredDate) {
        this.id = id;
        this.user = user;
        this.registredDate = registredDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public LocalDate getRegistredDate() {
        return registredDate;
    }

    public void setRegistredDate(LocalDate registredDate) {
        this.registredDate = registredDate;
    }
}
