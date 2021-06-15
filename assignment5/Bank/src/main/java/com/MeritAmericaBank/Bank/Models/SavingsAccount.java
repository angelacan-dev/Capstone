package com.MeritAmericaBank.Bank.Models;

import java.util.Date;

import com.MeritAmericaBank.Bank.Models.BankAccount;

public class SavingsAccount extends BankAccount {
	
	public SavingsAccount() {
		super();
	}
	
	public SavingsAccount(long accountNumber, double balance, double interestRate, Date openedOn) {
		super (accountNumber, balance, interestRate, openedOn);
	}
	
	
	public SavingsAccount(long accountNumber, double balance, double interestRate) {
		super(accountNumber, balance, interestRate);
	}
	
	public SavingsAccount(double balance, double interestRate) {
		super(balance, interestRate);
	}
	
	public SavingsAccount(double balance) {
		super(balance, .01);
	}

	
	public boolean withdraw(double amount) {
		if (amount < this.balance && amount > 0) {
			balance -= amount;
			return true;
		}  
		return false;
		
	}
	public boolean deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			return true;
		}
		return false;
	}
	
	public double futureValue(int years) {
		futureVal = Math.pow(1 + 0.01, years)* this.balance;
		return futureVal;
		
	}
	@Override
	public String toString() {
		return "SavingsAccount [balance=" + balance + ", interestRate=" + interestRate + ", futureVal=" + futureVal
				+ "]";
	}
	
	static SavingsAccount readFromString(String accountData) {
		String[] ad = accountData.split(",");	
		Date openedOn = convertToDate(ad[3]);
		SavingsAccount ca = new SavingsAccount(Integer.parseInt(ad[0]),Double.parseDouble(ad[1]), Double.parseDouble(ad[2]), openedOn);
		return ca;

	
	}
	

	
}