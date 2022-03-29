package com.cg.apps.tataskyapp.userms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.apps.tataskyapp.accountms.entity.Account;

@Entity
@Table(name = "userTab")
public class User {

	@Id
	private int id;
	@Column(length = 10)
	private String username;
	@Column(length = 10)
	private String firstName;
	@Column(length = 10)
	private String lastName;
	@Column(length = 10)
	private String password;
	@Column(length = 10)
	private String role;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountId")
	private Account account;

	public User(int id, String username, String firstName, String lastName, String password, String role, Account account) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

}
