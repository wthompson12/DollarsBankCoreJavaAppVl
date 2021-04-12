package com.dollarsbank.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name;
	private String address;
	private String contactNumber;
	public long accountNumber;
	double balance = 0;
	public String userId;
	private String password;
	private List<Customer> accounts;

	public Customer() {
		super();
	}

	public Customer(String name, String address, String contactNumber, Long accountNumber, String userId,
			String password) {
		super();
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
		this.accountNumber = accountNumber;
		this.balance = 0.0;
		this.userId = userId;
		this.password = password;
		accounts = new ArrayList<Customer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNo(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Customer> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Customer> accounts) {
		this.accounts = accounts;
	}

	public void deposit(double money) {
		this.balance += money;
	}

	public void withdraw(double money) {
		this.balance -= money;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", accountNumber=" + accountNumber + ", balance=" + balance + ", userId=" + userId + "]";
	}

	

	
}
