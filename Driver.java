package project;

import java.util.*;

public class Driver {
	public static void main(String[] args) {
		Account acc = new Account();
		Scanner scan = new Scanner(System.in);
		Bank bank = new Bank();

		double b;
		boolean flag = true;

		if (bank.uploadDataFile()) {
			System.out.println("The data are uploaded successfully\n");
		} else {
			System.out.println("Sorry, there is a problem\n");
		}

		do {
			bank.displayMainMenu();
			int n = scan.nextInt();
			switch (n) {
			case 1:
				System.out.println("Please enter the users information");
				int ID;
				String name;
				long phoneNumber;
				char type;
				double balance;
				try {

					System.out.print("ID: ");
					ID = scan.nextInt();

					System.out.print("Name: ");
					name = scan.next();

					System.out.print("Phone Number: ");
					phoneNumber = scan.nextLong();

					System.out.print("Account Type (enter s for saving, o for others): ");
					type = scan.next().charAt(0);

					System.out.print("Balance: ");
					balance = scan.nextDouble();

					acc = new Account(ID, name, phoneNumber, type, balance);
				} catch (InputMismatchException ex) {
					ex.printStackTrace();
				}

				if (bank.addAccount(acc)) {
					System.out.println("The account is added successfully\n");
				} else {
					System.out.println("Sorry, the account is exist before\n");
				}
				break;

			case 2:
				acc.displayAccounts();
				break;

			case 3:
				System.out.print("Please enter your id: ");
				int id = scan.nextInt();
				Account[] a = bank.returnAccountsArray();
				for (int i = 0; i < a.length; i++) {
					if (id == a[i].getID()) {
						System.out.print("Please enter the amount you want to add: ");
						double amount = scan.nextDouble();
						a[i].addAmount(amount);
						System.out.println("The amount is added successfully\n");
						break;
					} else if (i == a.length - 1) {
						System.out.println("Sorry, the id isn't exist\n");
					}
				}
				break;

			case 4:
				System.out.print("Please enter your id: ");
				id = scan.nextInt();
				a = bank.returnAccountsArray();
				for (int i = 0; i < a.length; i++) {
					if (id == a[i].getID()) {
						System.out.print("Please enter the amount you want to withdraw: ");
						double amount = scan.nextDouble();
						if (a[i].getType() == 's' && amount > 500) {
							System.out.println("Sorry, you can't withdraw more than 500\n");
						} else {
							if (a[i].withdrawAmount(amount)) {
								System.out.println("The amount is withdrawed successfully\n");
							} else {
								System.out.println("Sorry, Your balance is not enough\n");
							}
						}
						break;
					} else if (i == a.length - 1) {
						System.out.println("Sorry, the id isn't exist\n");
					}
				}
				break;

			case 5:
				System.out.println(
						"Please choose how do you want to search \n1. by ID \n2. By the holder name \n3. By part of the name");
				int choice = scan.nextInt();
				if (choice > 3 || choice <= 0) {
					System.out.println("Sorry, the choices are just 1-3\n");
				} else {
					acc = bank.viewAccountDetails(choice);
					if (acc == null) {
						System.out.println("Sorry, the account isn't exist\n");
					} else {
						acc.to_string();
					}
				}

				break;

			case 6:
				System.out.println(
						"Please choose how do you want to search about an account and modify \n1. By ID \n2. By the holder name \n3. By part of the name");
				choice = scan.nextInt();
				if (choice > 3 || choice <= 0) {
					System.out.println("Sorry, the choices are just 1-3\n");
				} else {
					bank.modifyAccountDetails(choice);
				}
				break;

			case 7:
				System.out.println("Please enter the accounts information which you want to close");

				System.out.print("ID: ");
				ID = scan.nextInt();

				System.out.print("Name: ");
				name = scan.next();

				System.out.print("Phone Number: ");
				phoneNumber = scan.nextLong();

				System.out.print("Account Type (enter s for saving, o for others): ");
				type = scan.next().charAt(0);

				System.out.print("Balance: ");
				balance = scan.nextDouble();

				acc = new Account(ID, name, phoneNumber, type, balance);

				if (bank.closeAccount(acc)) {
					System.out.println("The account is closed successfully\n");
				} else {
					System.out.println("Sorry, the account isn't exist\n");
				}
				break;

			case 8:
				flag = false;
				break;

			default:
				System.out.println("Sorry, the option is not exist\n");
				break;
			}

		} while (flag == true);

		if (bank.updateDataFile()) {
			System.out.println("The data aree updated successfully");
		} else {
			System.out.println("Sorry, there is a problem");
		}

	}
}
