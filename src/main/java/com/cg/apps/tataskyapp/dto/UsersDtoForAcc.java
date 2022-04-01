package com.cg.apps.tataskyapp.dto;

import com.cg.apps.tataskyapp.entities.Users;

public class UsersDtoForAcc {

    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    private String username;

    public UsersDtoForAcc() {

    }

    public UsersDtoForAcc(Users user) {
        this.role = user.getRole();
        this.lastName = user.getLastName();
        this.firstName = user.getLastName();
        this.username = user.getUsername();
        this.id = user.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
