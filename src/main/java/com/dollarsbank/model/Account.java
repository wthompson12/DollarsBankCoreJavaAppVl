package com.dollarsbank.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Account {

	// Class member variables
	public long accountNumber;
	//String accountHolder;
	double balance = 0;

	// Parameterised Constructor
	public Account(long accountNumber) {
		this.accountNumber = accountNumber;
		//this.accountHolder = accountHolder;
		this.balance = 0.0;
	}

	// Getters
	public long getAccountNumber() {
		return accountNumber;
	}

//	public String getAccountHolder() {
//		return accountHolder;
//	}

	public double getBalance() {
		return balance;
	}

	// Setters
	public void setAccountNo(long accountNumber) {
		this.accountNumber = accountNumber;
	}

//	public void setAccountHolder(String accountHolder) {
//		this.accountHolder = accountHolder;
//	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// Deposit
	public void deposit(double money) {
		this.balance += money;
	}

	// Withdraw money
	public void withdraw(double money) {
		this.balance -= money;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}

	
}
