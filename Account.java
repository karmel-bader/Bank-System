package project;

import java.util.*;
import java.io.*;

public class Account {
	private int ID;
	private String name;
	private long phoneNumber;
	private char accountType;
	private double balance;

	Bank bank = new Bank();

	public Account(int i, String n, long p, char a, double b) {
		ID = i;
		name = n;
		phoneNumber = p;
		accountType = a;
		balance = b;
	}

	public Account() {
	}

	public void displayAccounts() {

		Account[] accounts = bank.returnAccountsArray();

		for (int i = 0; i < accounts.length; i++) {
			accounts[i].to_string();
		}
		System.out.println("");

	}

	public void to_string() {
		System.out.println("ID is: " + ID + ", name is: " + name + ", phone number is: " + phoneNumber
				+ ", account type is: " + accountType + " and the balance is: " + balance);
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public char getType() {
		return accountType;
	}

	public void setData(int id, String n, long phone, char type) {
		ID = id;
		name = n;
		phoneNumber = phone;
		accountType = type;
	}

	public String returnData() {
		String s = ID + " " + name + " " + phoneNumber + " " + accountType + " " + balance;
		return s;
	}

	public void addAmount(double b) {
		balance += b;
	}

	public boolean withdrawAmount(double amount) {
		if (amount <= balance) {
			balance -= amount;
			return true;
		}

		else {
			return false;
		}
	}

}
