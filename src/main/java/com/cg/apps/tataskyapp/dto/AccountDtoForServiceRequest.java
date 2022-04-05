package com.cg.apps.tataskyapp.dto;

import com.cg.apps.tataskyapp.entities.Account;
import com.cg.apps.tataskyapp.entities.Pack;
import com.cg.apps.tataskyapp.entities.Recharge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountDtoForServiceRequest {

    private Long id;
    private LocalDate registeredDate;
    private Pack pack;
    private List<RechargeDtoForAcc> rechargeDtoForAccs;

    public AccountDtoForServiceRequest() {
    }

    public AccountDtoForServiceRequest(Account account) {
        this.id = account.getAccountId();
        this.registeredDate = account.getRegisteredDate();
        this.pack = account.getCurrentPack();
        List<Recharge> recharges = account.getRecharges();
        List<RechargeDtoForAcc> rechargeDtoForAccList = new ArrayList<>();
        for (Recharge recharge : recharges)
            rechargeDtoForAccList.add(new RechargeDtoForAcc(recharge));
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

    public List<RechargeDtoForAcc> getRechargeDtoForAccs() {
        return rechargeDtoForAccs;
    }

    public void setRechargeDtoForAccs(List<RechargeDtoForAcc> rechargeDtoForAccs) {
        this.rechargeDtoForAccs = rechargeDtoForAccs;
    }
}
