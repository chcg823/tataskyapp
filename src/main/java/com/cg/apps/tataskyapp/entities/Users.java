package com.cg.apps.tataskyapp.entities;

import com.cg.apps.tataskyapp.entities.Account;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 30, unique = true)
    private String username;
    @Column(length = 30)
    private String firstName;
    @Column(length = 30)
    private String lastName;
    @Column(length = 30)
    private String password;
    @Column(length = 10)
    private String role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")
    private Account account;

    public Users() {

    }

    public Users(Long id, String username, String firstName, String lastName, String password, String role,
                 Account account) {
        super();
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", account=" + account.getAccountId() +
                '}';
    }
}