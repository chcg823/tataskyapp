package com.cg.apps.tataskyapp.dto;

public class AccountDto {

    public Long id;
    public Long userId;

    public AccountDto() {

    }

    public AccountDto(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
