package com.dollarsbank.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dollarsbank.model.Account;
import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.model.Customer;

/**
 * Hello world!
 *
 */
public class App {
	
	// Required objects
	List<Customer>customers = new ArrayList<Customer>();
	//static ArrayList<Account> accounts = new ArrayList();
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = 0;
		// Greetings
		System.out.println("===================================");
		System.out.println("DOLLARSBANK Welcomes You!");
		System.out.println("===================================");
		// Menu
		System.out.println("1. Create an account \n2. Login\n3. Exit");
		// Loops till user wants to quit
		while (n != 5) {
			// Reads user options from menu
			System.out.print("\nSelect an option from menu : ");
			n = s.nextInt();
			// Calls appropriate method
			switch (n) {
			case 1:
				createAccount();
				break;
			case 2:
				depositMoney();
				break;
			case 3:
				withdrawMoney();
				break;
			case 4:
				checkBalance();
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid Option.. Try Again...");
				break;
			}
			System.out.println("\n============================================");
		}
	}

	// Implementation of createAccount
	public static void createAccount() {
		// Required variables
		long accountNo;
		String name, ignore;
		boolean exists = false;
		// Reads account number
		System.out.print("Enter account No. : ");
		accountNo = s.nextLong();
		// Validates account number
		while (String.valueOf(accountNo).length() != 6 || accountNo < 0) {
			System.out.println("Account Number should be a six digit positve value.");
			System.out.print("Enter account No. : ");
			accountNo = s.nextLong();
		}
		// Reads account holder name
		System.out.print("Enter account holder name : ");
		ignore = s.nextLine();
		name = s.nextLine();
		// Checks if the account with given number already exists
		if (accounts.size() > 0) {
			for (Account a : accounts) {
				if (a.accountNo == accountNo) {
					exists = true;
					System.out.println("Account already exists");
					System.out.println("1. Create an account.\n2. Deposit money.\n3. Withdraw money.\n4. Check Balance.\n5. Quit");
				}
			}
			if (!exists) {
				// If the account does not exist befor creates account
				accounts.add(new Account(accountNo, name));
				System.out.println("\nAccount created successfully");
				System.out.println("1. Create an account.\n2. Deposit money.\n3. Withdraw money.\n4. Check Balance.\n5. Quit");
			}
		} else {
			accounts.add(new Account(accountNo, name));
			System.out.println("\nAccount created successfully");
			System.out.println("1. Create an account.\n2. Deposit money.\n3. Withdraw money.\n4. Check Balance.\n5. Quit");
		}
	}

	// Implementation of depositMoney()
	public static void depositMoney() {
		// Required variables
		double amount;
		long accountNo;
		boolean exists = false;
		if (accounts.size() > 0) {
			// Reads account number
			System.out.print("Enter account No. : ");
			accountNo = s.nextLong();
			for (Account a : accounts) {
				// Checks if the account exists
				if (a.accountNo == accountNo) {
					exists = true;
					// Reads amount to deposit
					System.out.print("Enter amount to deposit : ");
					amount = s.nextDouble();
					// Validates amount
					while (amount <= 0) {
						System.out.println("Please enter amount greater than 0.");
						System.out.print("Enter amount to deposit : ");
						amount = s.nextDouble();
					}
					a.deposit(amount);
					System.out.println("Amount deposited successfully");
					System.out.println("1. Create an account.\n2. Deposit money.\n3. Withdraw money.\n4. Check Balance.\n5. Quit");
				}
			}
			if (!exists) {
				System.out.println("Account with number " + accountNo + " does not exists.");
				System.out.println("1. Create an account.\n2. Deposit money.\n3. Withdraw money.\n4. Check Balance.\n5. Quit");
			}
		} else {
			System.out.println("No bank accounts available.");
			System.out.println("1. Create an account.\n2. Deposit money.\n3. Withdraw money.\n4. Check Balance.\n5. Quit");
		}
	}

	// Implementaton of withdrawMoney
	public static void withdrawMoney() {
		double amount;
		long accountNo;
		double balance;
		boolean exists = false;
		if (accounts.size() > 0) {
			// Reads account number
			System.out.print("Enter account No. : ");
			accountNo = s.nextLong();
			for (Account a : accounts) {
				// Checks if the account exists
				if (a.accountNo == accountNo) {
					exists = true;
					// Reads amount to withdraw
					System.out.print("Enter amount to withdraw : ");
					amount = s.nextDouble();
					balance = a.getBalance();
					// If available balance is lesser than amount to withdraw
					if (amount > balance) {
						System.out.println("You don't have enough balance.");
						System.out.println("1. Create an account.\n2. Deposit money.\n3. Withdraw money.\n4. Check Balance.\n5. Quit");
					} else {
						// Otherwise
						a.withdraw(amount);
						System.out.println("Amount withdrew successfully");
						System.out.println("1. Create an account.\n2. Deposit money.\n3. Withdraw money.\n4. Check Balance.\n5. Quit");
					}
				}
			}
			if (!exists) {
				System.out.println("Account with number " + accountNo + " does not exists.");
				System.out.println("1. Create an account.\n2. Deposit money.\n3. Withdraw money.\n4. Check Balance.\n5. Quit");
			}
		} else {
			System.out.println("No bank accounts available.");
			System.out.println("1. Create an account.\n2. Deposit money.\n3. Withdraw money.\n4. Check Balance.\n5. Quit");
		}
	}

	// Implemntation of checkBalance
	public static void checkBalance() {
		long accountNo;
		boolean exists = false;
		if (accounts.size() > 0) {
			// Reads account number
			System.out.print("Enter account No. : ");
			accountNo = s.nextLong();
			for (Account a : accounts) {
				// Checks if the account exists
				if (a.accountNo == accountNo) {
					exists = true;
					System.out.println("============================================");
					System.out.println(a);
					System.out.println("============================================");
				}
			}
			if (!exists) {
				System.out.println("Account with number " + accountNo + " does not exists.");
				System.out.println("1. Create an account.\n2. Deposit money.\n3. Withdraw money.\n4. Check Balance.\n5. Quit");
			}
		} else {
			System.out.println("No bank accounts available.");
			//System.out.println("1. Create an account.\n2. Deposit money.\n3. Withdraw money.\n4. Check Balance.\n5. Quit");
		}
	}
}
