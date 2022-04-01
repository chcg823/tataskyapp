package com.cg.apps.tataskyapp.dto;

import java.time.LocalDate;

public class AccountDto {

    private Long id;
    private Long userId;
    private Long packId;
    private LocalDate registeredDate;

    public AccountDto() {

    }

    public AccountDto(Long id, Long userId, Long packId, LocalDate registeredDate) {
        this.id = id;
        this.userId = userId;
        this.packId = packId;
        this.registeredDate = LocalDate.now();
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

    public Long getPackId() {
        return packId;
    }

    public void setPackId(Long packId) {
        this.packId = packId;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }
}
