package project;

import java.util.*;
import java.io.*;

public class Bank {
	static Account[] accounts;
	static int size = 0;

	public void displayMainMenu() {
		System.out.println("Please Select an Operation (1-8): ");
		System.out.println("1- Add Account");
		System.out.println("2- View All Accounts");
		System.out.println("3- Add Amount");
		System.out.println("4- Withdraw Amount");
		System.out.println("5- View Account Details");
		System.out.println("6- Modify Account");
		System.out.println("7- Close an Account");
		System.out.println("8- Exit");

	}

	public Account[] returnAccountsArray() {
		return accounts;
	}

	public boolean addAccount(Account a) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getID() == a.getID()) {
				return false;
			}
		}
		size++;
		Account[] k = new Account[size];

		for (int i = 0; i < accounts.length; i++) {
			k[i] = accounts[i];
		}
		k[size - 1] = a;
		accounts = k;

		return true;
	}

	public boolean closeAccount(Account a) {
		for (int i = 0; i < accounts.length; i++) {
			try {
				if (accounts[i].returnData().compareTo(a.returnData()) == 1) {
					continue;
				} else {
					size--;
					Account[] b = new Account[size];
					int x = 0;
					for (int j = 0; j < accounts.length; j++) {
						if (accounts[j].returnData().compareTo(a.returnData()) == 0) {
							continue;
						}
						if (x < size) {
							b[x] = accounts[j];
						}
						x++;
					}
					accounts = b;
					return true;
				}
			} catch (ArrayIndexOutOfBoundsException ex) {
				ex.printStackTrace();
			}
		}
		return false;
	}

	public Account viewAccountDetails(int choice) {
		Scanner scan = new Scanner(System.in);
		switch (choice) {
		case 1:
			System.out.print("please enter the ID you want to search about: ");
			int id = scan.nextInt();
			for (int i = 0; i < accounts.length; i++) {
				if (accounts[i].getID() == id) {
					return accounts[i];
				}
			}
			return null;

		case 2:
			System.out.print("please enter the name you want to search about: ");
			String name = scan.next();
			for (int i = 0; i < accounts.length; i++) {
				if (accounts[i].getName().compareTo(name) == 0) {
					return accounts[i];
				}
			}
			return null;

		default:
			System.out.print("please enter the part of the name you want to search about: ");
			String namePart = scan.next();
			for (int i = 0; i < accounts.length; i++) {
				if (accounts[i].getName().contains(namePart)) {
					return accounts[i];
				}
			}
			return null;

		}

	}

	public void modifyAccountDetails(int choice) {
		Scanner scan = new Scanner(System.in);
		switch (choice) {
		case 1:
			System.out.print("please enter the ID of the account you want to modify: ");
			int id = scan.nextInt();
			for (int i = 0; i < accounts.length; i++) {
				try {
					if (accounts[i].getID() == id) {
						System.out.print("Your old account details: ");
						accounts[i].to_string();

						System.out.print("Enter the new details\nNew ID: ");
						int newId = scan.nextInt();

						System.out.print("New Name: ");
						String newName = scan.next();

						System.out.print("New Phone Number: ");
						long newPhoneNumber = scan.nextLong();

						System.out.print("New Account Type (s:saving, o:others): ");
						char newAccountType = scan.next().charAt(0);

						for (int j = 0; j < accounts.length; j++) {
							if (id == newId) {
								accounts[i].setData(newId, newName, newPhoneNumber, newAccountType);
								System.out.println("Your data are modified successfully\n");
								break;
							} else if (id != newId && accounts[j].getID() == newId) {
								System.out.println("Sorry, the id is exist before\n");
								break;
							} else {
								if (j == accounts.length - 1) {
									accounts[i].setData(newId, newName, newPhoneNumber, newAccountType);
									System.out.println("Your data are modified successfully\n");
									break;
								}
							}
						}
						break;

					}
				} catch (InputMismatchException ex) {
					System.out.println("Your input isn't allowed\n");
				}
			}
			break;

		case 2:
			System.out.print("please enter the name of the account you want to modify: ");
			String name = scan.next();
			for (int i = 0; i < accounts.length; i++) {
				if (accounts[i].getName().compareTo(name) == 0) {
					System.out.print("Your old account details: ");
					accounts[i].to_string();

					System.out.print("Enter the new details\nNew ID: ");
					int newId = scan.nextInt();

					System.out.print("New Name: ");
					String newName = scan.next();

					System.out.print("New Phone Number: ");
					long newPhoneNumber = scan.nextLong();

					System.out.print("New Account Type (s:saving, o:others): ");
					char newAccountType = scan.next().charAt(0);

					id = accounts[i].getID();
					for (int j = 0; j < accounts.length; j++) {
						if (id == newId) {
							accounts[i].setData(newId, newName, newPhoneNumber, newAccountType);
							System.out.println("Your data are modified successfully\n");
							break;
						} else if (id != newId && accounts[j].getID() == newId) {
							System.out.println("Sorry, the id is exist before\n");
							break;
						} else {
							if (j == accounts.length - 1) {
								accounts[i].setData(newId, newName, newPhoneNumber, newAccountType);
								System.out.println("Your data are modified successfully\n");
								break;
							}
						}
					}
					break;
				}
			}
			break;

		case 3:
			System.out.print("please enter the part of name of the account you want to modify: ");
			name = scan.next();
			for (int i = 0; i < accounts.length; i++) {
				if (accounts[i].getName().contains(name)) {
					System.out.print("Your old account details: ");
					accounts[i].to_string();

					System.out.print("Enter the new details\nNew ID: ");
					int newId = scan.nextInt();

					System.out.print("New Name: ");
					String newName = scan.next();

					System.out.print("New Phone Number: ");
					long newPhoneNumber = scan.nextLong();

					System.out.print("New Account Type (s:saving, o:others): ");
					char newAccountType = scan.next().charAt(0);
					id = accounts[i].getID();
					for (int j = 0; j < accounts.length; j++) {
						if (id == newId) {
							accounts[i].setData(newId, newName, newPhoneNumber, newAccountType);
							System.out.println("Your data are modified successfully\n");
							break;
						} else if (id != newId && accounts[j].getID() == newId) {
							System.out.println("Sorry, the id is exist before\n");
							break;
						} else {
							if (j == accounts.length - 1) {
								accounts[i].setData(newId, newName, newPhoneNumber, newAccountType);
								System.out.println("Your data are modified successfully\n");
								break;
							} else {
								continue;
							}
						}
					}
				}
			}
			break;
		}
	}

	public boolean updateDataFile() {
		File output = new File("Account.txt");

		try {
			PrintWriter out = new PrintWriter(output);
			for (int i = 0; i < accounts.length; i++) {
				out.println(accounts[i].returnData());
			}
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}

	public boolean uploadDataFile() {
		File data = new File("Account.txt");

		Scanner scan, scan2;

		try {
			scan = new Scanner(data);
			String s;
			while (scan.hasNext() == true) {
				s = scan.nextLine();
				size++;
			}
			accounts = new Account[size];

			scan2 = new Scanner(data);
			for (int i = 0; i < size; i++) {

				s = scan2.nextLine();
				String[] a = s.split(" ");

				int ID = Integer.parseInt(a[0]);
				long phoneNumber = Long.parseLong(a[2]);
				char type = a[3].charAt(0);
				double balance = Double.parseDouble(a[4]);

				accounts[i] = new Account(ID, a[1], phoneNumber, type, balance);
			}

			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}
}
