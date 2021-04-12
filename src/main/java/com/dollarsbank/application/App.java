package com.dollarsbank.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ColorsUtility;


public class App {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		
		int n = 0;

		System.out.println("--------------------------");
		System.out.println(ColorsUtility.ANSI_BLUE + "DOLLARSBANK Welcomes You!" + ColorsUtility.ANSI_RESET);
		System.out.println("--------------------------");

		System.out.println(ColorsUtility.ANSI_BLACK +"1. Create an account \n2. Login\n3. Exit" + ColorsUtility.ANSI_RESET);

		while (n != 3) {

			System.out.print(ColorsUtility.ANSI_GREEN + "\n Make your selection : " + ColorsUtility.ANSI_GREEN);
			n = s.nextInt();

			switch (n) {
			case 1:
				DollarsBankController.createAccount();
				break;
			case 2:
				DollarsBankController.login();
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println(ColorsUtility.ANSI_RED + "Invalid Option. Try Again!." + ColorsUtility.ANSI_RESET);
				break;
			}
			System.out.println("\n--------------------------");
		}
	}

	
}
