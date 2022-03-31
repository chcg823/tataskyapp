package com.cg.apps.tataskyapp.dto;

import ch.qos.logback.classic.pattern.LineOfCallerConverter;
import com.cg.apps.tataskyapp.entities.Recharge;

import java.time.LocalDate;
import java.util.List;

public class RechargeToForAcc {

    private Long id;
    private Double amount;
    private Integer daysValidity;
    private String planDescription;
    private String planName;
    private LocalDate purchasedDate;
    private List<String> channels;
    private boolean active;

    public RechargeToForAcc() {
        super();
    }

    public RechargeToForAcc(Recharge recharge) {
        super();
        this.id = recharge.getId();
        this.amount = recharge.getAmount();
        this.daysValidity = recharge.getDaysValidity();
        this.planDescription = recharge.getPlanDescription();
        this.planName = recharge.getPlanName();
        this.purchasedDate = recharge.getPurchasedDate();
        this.channels = recharge.getChannels();
        this.active = recharge.isActive();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getDaysValidity() {
        return daysValidity;
    }

    public void setDaysValidity(Integer daysValidity) {
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
