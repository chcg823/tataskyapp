package com.cg.apps.tataskyapp.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "recharge")
public class Recharge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;
    @Column(length = 10)
    private double amount;
    @Column(length = 10)
    private int daysValidity;
    @Column(length = 25)
    private String planDescription;
    @Column(length = 15)
    private String planName;
    @Column
    private LocalDate purchasedDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pack_id")
    private Pack pack;
    @ElementCollection
    private List<String> channels;
    private boolean active;

    public Recharge() {

    }

    public Recharge(long id, Account account, double amount, int daysValidity, String planDescription, String planName,
                    LocalDate purchasedDate, Pack pack, List<String> channels, boolean active) {
        this.id = id;
        this.account = account;
        this.amount = amount;
        this.daysValidity = daysValidity;
        this.planDescription = planDescription;
        this.planName = planName;
        this.purchasedDate = purchasedDate;
        this.pack = pack;
        this.channels = channels;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    @Override
    public String toString() {
        return "Recharge{" +
                "id=" + id +
                ", account=" + account +
                ", amount=" + amount +
                ", daysValidity=" + daysValidity +
                ", planDescription='" + planDescription + '\'' +
                ", planName='" + planName + '\'' +
                ", purchasedDate=" + purchasedDate +
                ", pack=" + pack +
                ", channels=" + channels +
                ", active=" + active +
                '}';
    }
}