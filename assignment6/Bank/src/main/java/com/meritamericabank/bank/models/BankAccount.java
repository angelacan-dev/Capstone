package com.meritamericabank.bank.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Date.*;

import javax.persistence.Entity;

@Entity
public class BankAccount {
	static SimpleDateFormat SDF = new SimpleDateFormat ("MM/dd/yyyy");
	protected double balance; //protected allows us to view these properties in the children classes
	protected double interestRate;
	protected long accountNumber;
	protected double futureVal;
	protected int term;
	protected Date openedOn;
	
	public BankAccount() {
		
	}
	
	public BankAccount(long accountNumber, double balance, double interestRate) {
		this(balance, interestRate);
		this.accountNumber = accountNumber;
		
	}
	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountNumber = MeritBank.getNextAccountNumber();
	}
	
	public BankAccount(long accountNumber, double balance, double interestRate, Date openedOn) {
		this(accountNumber, balance, interestRate);
		this.openedOn = openedOn;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	public boolean withdraw(double amount) {
		if (amount <= 0) {
		return false;
	}
		this.balance -= amount;
		return true;
	}
	
	public boolean deposit(double amount) {
		if (amount <= 0) {
			return false;
		}
			this.balance += amount;
			return true;
		

	}
	
	public double futureValue(int term) {
		return this.balance * Math.pow((1 + this.interestRate), term);
	}
	
	static Date convertToDate (String d) {
		try {
			return SDF.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return new Date();
		}
	}
	
//	static BankAccount readFromString(String accountData) {
//		String[] ad = accountData.split(",");	
//		Date openedOn = convertToDate(ad[3]);
//		BankAccount ca = new BankAccount(Integer.parseInt(ad[0]),Double.parseDouble(ad[1]), Double.parseDouble(ad[2]), openedOn);
//		return ca;
//
//	
//	}
}