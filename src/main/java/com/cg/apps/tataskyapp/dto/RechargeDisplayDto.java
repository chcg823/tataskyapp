package com.cg.apps.tataskyapp.dto;

import com.cg.apps.tataskyapp.entities.Pack;
import com.cg.apps.tataskyapp.entities.Recharge;

import java.time.LocalDate;
import java.util.List;

public class RechargeDisplayDto {

    private long id;
    private double amount;
    private int daysValidity;
    private String planDescription;
    private String planName;
    private LocalDate purchasedDate;
    private Pack pack;
    private List<String> channels;
    private boolean active;

    public RechargeDisplayDto() {

    }

    public RechargeDisplayDto(Recharge recharge) {
        this.id = recharge.getId();
        this.amount = recharge.getAmount();
        this.daysValidity = recharge.getDaysValidity();
        this.planDescription = recharge.getPlanDescription();
        this.planName = recharge.getPlanName();
        this.purchasedDate = recharge.getPurchasedDate();
        this.pack = recharge.getPack();
        this.channels = recharge.getChannels();
        this.active = recharge.isActive();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getDaysValidity() {
        return daysValidity;
    }

    public void setDaysValidity(int daysValidity) {
        this.daysValidity = daysValidity;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public LocalDate getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(LocalDate purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
