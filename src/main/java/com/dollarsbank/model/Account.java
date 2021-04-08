package com.dollarsbank.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Account {

	// Class member variables
	public long accountNo;
	String accountHolder;
	double balance = 0;

	// Parameterised Constructor
	public Account(long accountNo, String accountHolder) {
		this.accountNo = accountNo;
		this.accountHolder = accountHolder;
		this.balance = 0.0;
	}

	// Getters
	public long getAccountNo() {
		return accountNo;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	// Setters
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

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
		return String.format("%-20s : %d\n%-20s : %s\n%-20s : %.2f\n", "Account No. ", accountNo, "Account Holder ",
				accountHolder, "Balance ", balance);
	}
}
