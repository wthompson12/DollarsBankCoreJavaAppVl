package com.dollarsbank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dollarsbank.application.App;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ColorsUtility;

public class DollarsBankController {

	static List<Customer> customers = new ArrayList<Customer>();
	// static ArrayList<Account> accounts = new ArrayList<Account>();
	static Scanner s = new Scanner(System.in);

	public static void createAccount() {
		long accountNumber;
		String name = "";
		String address = "";
		String contactNumber = "";
		String userId;
		String ignore;
		String password;
		boolean exists = false;

		System.out.print(ColorsUtility.ANSI_BLACK +"Enter checking account number: " + ColorsUtility.ANSI_RESET);
		accountNumber = s.nextLong();

		while (String.valueOf(accountNumber).length() != 6 || accountNumber < 0) {
			System.out.println(ColorsUtility.ANSI_RED + "Account Number needs to be 6 digits" + ColorsUtility.ANSI_RESET);
			System.out.print(ColorsUtility.ANSI_BLACK + "Enter account Number: " + ColorsUtility.ANSI_RESET);
			accountNumber = s.nextLong();
		}

		System.out.print(ColorsUtility.ANSI_BLACK + "Enter your userId : " + ColorsUtility.ANSI_RESET);
		ignore = s.nextLine();
		userId = s.nextLine();

		System.out.print(ColorsUtility.ANSI_BLACK + "Enter your Name : " + ColorsUtility.ANSI_RESET);
		name = s.nextLine();

		System.out.print(ColorsUtility.ANSI_BLACK + "Enter your Address : " + ColorsUtility.ANSI_RESET);
		address = s.nextLine();

		System.out.print(ColorsUtility.ANSI_BLACK + "Enter your Contact Number : " + ColorsUtility.ANSI_RESET);
		contactNumber = s.nextLine();

//			System.out.print("Enter your initial deposit : ");
//			deposit();
//			
		if (customers.size() > 0) {
			for (Customer customer : customers) {
				if (customer.userId == userId) {
					exists = true;
					System.out.println("Account already exists");
					System.out.println(ColorsUtility.ANSI_BLACK + "1. Create an account \n2. Login\n3. Exit" + ColorsUtility.ANSI_RESET);
				}
			}
			if (!exists) {
				System.out.print(ColorsUtility.ANSI_BLACK + "Enter your password: " + ColorsUtility.ANSI_RESET);
				password = s.nextLine();
				customers.add(new Customer(name, address, contactNumber, accountNumber, userId, password));
				System.out.println(ColorsUtility.ANSI_CYAN+ "\nAccount created successfully" + ColorsUtility.ANSI_RESET);
				System.out.println(ColorsUtility.ANSI_BLACK + "1. Create an account \n2. Login\n3. Exit" + ColorsUtility.ANSI_RESET);
			}
		} else {
			System.out.print(ColorsUtility.ANSI_BLACK + "Enter your password: " + ColorsUtility.ANSI_RESET);
			password = s.nextLine();
			customers.add(new Customer(name, address, contactNumber, accountNumber, userId, password));
			System.out.println(ColorsUtility.ANSI_CYAN+ "\nAccount created successfully" + ColorsUtility.ANSI_RESET);
			System.out.println(ColorsUtility.ANSI_BLACK + "1. Create an account \n2. Login\n3. Exit" + ColorsUtility.ANSI_RESET);
		}
	}

	public static Customer login() {
		int n = 0;
		String userId;
		String password;
		while (true) {
			System.out.print(ColorsUtility.ANSI_BLACK + "\nUserId: " + ColorsUtility.ANSI_RESET);
			userId = s.nextLine();
			System.out.print(ColorsUtility.ANSI_BLACK + "\nPassword: " + ColorsUtility.ANSI_RESET);
			password = s.nextLine();

			for (Customer customer : customers) {
				if (customer.getUserId().equals(userId) && customer.getPassword().equals(password)) {
					while (n != 5) {
						System.out.print(ColorsUtility.ANSI_GREEN + "\n Make your selection : " + ColorsUtility.ANSI_RESET);
						System.out.println(ColorsUtility.ANSI_BLACK + "\n1. Deposit \n2. Withdraw \n3. Check Balance \n4. Sign Out" + ColorsUtility.ANSI_RESET);
						n = s.nextInt();

						switch (n) {
						case 1:
							deposit();
							break;
						case 2:
							withdraw();
							break;
						case 3:
							customerInfo();
							break;
						case 4:
							App.main(null);
							break;
						default:
							System.out.println(ColorsUtility.ANSI_RED + "Invalid Option.. Try Again..." + ColorsUtility.ANSI_RESET);
							break;
						}
						System.out.println("\n--------------------------");
					}
					return customer;
				}

			}
			System.out.println(ColorsUtility.ANSI_RED + "Invalid Credentials. Try Again!" + ColorsUtility.ANSI_RESET);
			App.main(null);
		}
	}

	public static void deposit() {
		double amount;
		long accountNumber;
		boolean exists = false;
		if (customers.size() > 0) {
			System.out.print(ColorsUtility.ANSI_BLACK + "Enter account Number. : " + ColorsUtility.ANSI_RESET);
			accountNumber = s.nextLong();
			for (Customer customer : customers) {
				if (customer.accountNumber == accountNumber) {
					exists = true;
					System.out.print(ColorsUtility.ANSI_BLACK + "Enter amount to deposit : " + ColorsUtility.ANSI_RESET);
					amount = s.nextDouble();
					while (amount <= 0) {
						System.out.println(ColorsUtility.ANSI_RED + "Please enter amount greater than 0." + ColorsUtility.ANSI_RESET);
						System.out.print(ColorsUtility.ANSI_BLACK + "Enter amount to deposit : " + ColorsUtility.ANSI_RESET);
						amount = s.nextDouble();
					}
					customer.deposit(amount);
					System.out.println(ColorsUtility.ANSI_CYAN + "Amount deposited successfully" + ColorsUtility.ANSI_RESET);
				}
			}
			if (!exists) {
				System.out.println(ColorsUtility.ANSI_RED + "Account with number " + accountNumber + " does not exists." + ColorsUtility.ANSI_RESET);
			}
		} else {
			System.out.println(ColorsUtility.ANSI_BLACK + "Number bank accounts available." + ColorsUtility.ANSI_RESET);
		}
	}

	public static void withdraw() {
		double amount;
		long accountNumber;
		double balance;
		boolean exists = false;
		if (customers.size() > 0) {
			System.out.print(ColorsUtility.ANSI_BLACK + "Enter account Number. : " + ColorsUtility.ANSI_RESET);
			accountNumber = s.nextLong();
			for (Customer customer : customers) {
				if (customer.accountNumber == accountNumber) {
					exists = true;
					System.out.print(ColorsUtility.ANSI_BLACK + "Enter amount to withdraw : " + ColorsUtility.ANSI_RESET);
					amount = s.nextDouble();
					balance = customer.getBalance();
					if (amount > balance) {
						System.out.println(ColorsUtility.ANSI_RED + "You don't have enough balance." + ColorsUtility.ANSI_RESET);
					} else {
						customer.withdraw(amount);
						System.out.println(ColorsUtility.ANSI_CYAN + "Amount withdrew successfully" + ColorsUtility.ANSI_RESET);
					}
				}
			}
			if (!exists) {
				System.out.println(ColorsUtility.ANSI_RED + "Account with number " + accountNumber + " does not exists." + ColorsUtility.ANSI_RESET);
			}
		} else {
			System.out.println(ColorsUtility.ANSI_BLACK + "Number bank accounts available." + ColorsUtility.ANSI_RESET);
		}
	}

	public static void customerInfo() {
		long accountNumber;
		boolean exists = false;
		if (customers.size() > 0) {
			System.out.print(ColorsUtility.ANSI_BLACK + "Enter account Number. : " + ColorsUtility.ANSI_RESET);
			accountNumber = s.nextLong();
			for (Customer customer : customers) {
				if (customer.accountNumber == accountNumber) {
					exists = true;
					System.out.println("--------------------------");
					System.out.println(ColorsUtility.ANSI_BLACK + customer + ColorsUtility.ANSI_RESET);
					System.out.println("--------------------------");
				}
			}
			if (!exists) {
				System.out.println(ColorsUtility.ANSI_RED + "Account with number " + accountNumber + " does not exists." + ColorsUtility.ANSI_RESET);
			}
		} else {
			System.out.println(ColorsUtility.ANSI_BLACK + "Number bank accounts available." + ColorsUtility.ANSI_RESET);
		}
	}

}
