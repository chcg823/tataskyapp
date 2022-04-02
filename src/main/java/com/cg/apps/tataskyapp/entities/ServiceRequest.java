package com.cg.apps.tataskyapp.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "servicerequest")
public class ServiceRequest {
    @Id
    @Column(name = "service_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "requestDate")
    private LocalDate requestDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;
    @Column(name = "message", length = 30)
    private String message;
    @Column(name = "status")
    private Boolean statusOpened;

    public ServiceRequest() {
    }

    public ServiceRequest(LocalDate requestDate, Account account, String message, Boolean statusOpened) {
        this.requestDate = requestDate;
        this.account = account;
        this.message = message;
        this.statusOpened = statusOpened;
    }

    public ServiceRequest(String message) {
        this.message = message;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    @Override
    public String toString() {
        return "ServiceRequest{" +
                "id=" + id +
                ", requestDate=" + requestDate +
                ", account=" + account.getAccountId() +
                ", message='" + message + '\'' +
                ", statusOpened=" + statusOpened +
                '}';
    }
}