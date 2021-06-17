package com.meritamericabank.bank.models;

import java.util.Date;

import com.meritamericabank.bank.models.BankAccount;

public class CDAccount extends BankAccount{
	
	public CDAccount(int term, double balance) {
		this.term = term;
	}
	
	public CDAccount(long accountNumber, double balance, double interestRate) {
		super (accountNumber, balance, interestRate);
	}
	
	public CDAccount(long accountNumber, double balance, double interestRate, Date openedOn, int term) {
		super (accountNumber, balance, interestRate, openedOn);
		this.term = term;
	}
	
	
	public CDAccount(double balance, double interestRate) {
		super(balance, interestRate);
	}
	
	public CDAccount(double balance) {
		super(balance, .0001);
	}

	@Override //anytime CDAccount object tries to call withdraw or deposit it will return false
	public boolean deposit(double balance ) {
		return false;
	}
	
	@Override
	public boolean withdraw(double bal) {
		return false;
	}
	
	
	static CDAccount readFromString(String accountData) {
		String[] ad = accountData.split(",");	
		Date openedOn = convertToDate(ad[3]);
		CDAccount ca = new CDAccount(Integer.parseInt(ad[0]),Double.parseDouble(ad[1]), Double.parseDouble(ad[2]), openedOn, Integer.parseInt(ad[4]));
		return ca;

	
	}
	
	
}
