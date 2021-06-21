package com.meritamericabank.bank.models;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AccountHolder {
	static int counter = 1;
	private int accountId;
	//private instance variables, if we're passing to the constructor it needs to exist in the object
	@NotBlank(message = "This field cannot be blank")
	private String firstName;
	private String middleName;
	@NotBlank(message = "This field cannot be blank")
	private String lastName;
	@NotNull(message = "This field cannot be blank")
	private int ssn;
	
	private CheckingAccount[] checkingAccounts;
	private SavingsAccount[] savingsAccounts;
	private CDAccount[] cdAccounts;
	
	public AccountHolder() {
		checkingAccounts = new CheckingAccount[0];
		savingsAccounts = new SavingsAccount[0];
		cdAccounts = new CDAccount[0];
	}
	
	//Parameterized constructor
	public AccountHolder(String firstName, String middleName, String lastName, int ssn) {
		this();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
	
	}
	//methods with the same name but different arguments provided is called overloading
	public CheckingAccount addCheckingAccount(CheckingAccount a) {
		double combined = getCheckingBalance() + getSavingsBalance() + a.getBalance();
		System.out.println("new Balance :" +a.getBalance());
		if(getCheckingBalance() + getSavingsBalance() + a.getBalance() < 250000) {
			System.out.println("inside checking account");
			CheckingAccount[] temp = new CheckingAccount[checkingAccounts.length + 1];
			for (int i = 0; i < checkingAccounts.length; i++) {
				temp[i] = checkingAccounts[i];
			}
			temp[temp.length - 1] = a;
			checkingAccounts = temp;
			return a;
		}
		else {
			return null;
		}
			
	}
	public static int getCounter() {
		return counter;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public int getNumberOfCheckingAccounts() {
		return this.checkingAccounts.length; //length of the array will always be the number of unique CA we have
	}
	
	public double getCheckingBalance() {
		double total = 0; //start with sum being 0, look into every single CA in our CA variable, increase total by balance of that and return total
		System.out.println("checking account array length : " +checkingAccounts.length);
		
		//for(CheckingAccount a : checkingAccounts) {
		//	total += a.getBalance();
		//	System.out.println("balance is :" +total);
		//}
		
		for(int i = 0 ; i < checkingAccounts.length ; i++) {
			total += checkingAccounts[i].getBalance();
		}
		return total;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSSN() {
		return ssn;
	}

	public void setSSN(int ssn) {
		this.ssn = ssn;
	}

	public CheckingAccount[] getCheckingAccounts() {
		return checkingAccounts;
	}

	public void setCheckingAccounts(CheckingAccount[] checkingAccounts) {
		this.checkingAccounts = checkingAccounts;
	}

	public SavingsAccount[] getSavingsAccounts() {
		return savingsAccounts;
	}

	public void setSavingsAccounts(SavingsAccount[] savingsAccounts) {
		this.savingsAccounts = savingsAccounts;
	}

	public CDAccount[] getCDAccounts() {
		return cdAccounts;
	}

	public void setCdAccounts(CDAccount[] cdAccounts) {
		this.cdAccounts = cdAccounts;
	}
	public SavingsAccount addSavingsAccount(SavingsAccount a) {
		if(getCheckingBalance() + getSavingsBalance() + a.getBalance() < 250000) {
		SavingsAccount[] temp = new SavingsAccount[savingsAccounts.length + 1];
		for (int i = 0; i < savingsAccounts.length; i++) {
			temp[i] = savingsAccounts[i];
		}
		temp[temp.length - 1] = a;
		savingsAccounts = temp;
		
		return a;
		}
		else
			return null;
	}
	
	public SavingsAccount addSavingsAccount(double amount) {
		return addSavingsAccount(new SavingsAccount(amount));
	}
	
	public int getNumberOfSavingsAccounts() {
		return this.savingsAccounts.length; //length of the array will always be the number of unique CA we have
	}
	
	public double getSavingsBalance() {
		double total = 0; //start with sum being 0, look into every single CA in our CA variable, increase total by balance of that and return total
		for(SavingsAccount a : savingsAccounts) {
			total += a.getBalance();
		}
		return total;
	}
	
	public CDAccount addCDAccount(CDAccount a) {
		CDAccount[] temp = new CDAccount[cdAccounts.length + 1];
		for (int i = 0; i < cdAccounts.length; i++) {
			temp[i] = cdAccounts[i];
		}
		temp[temp.length - 1] = a;
		cdAccounts = temp;
		
		return a;
	}
	
	//public CDAccount addCDAccount(CDOffering offering, double amount) {
		
		//return addCDAccount(new CDAccount(offering, amount));
	//}
	
	public int getNumberOfCDAccounts() {
		return this.cdAccounts.length; //length of the array will always be the number of unique CA we have
	}
	
	public double getCDBalance() {
		double total = 0; //start with sum being 0, look into every single CA in our CA variable, increase total by balance of that and return total
		for(CDAccount a : cdAccounts) {
			total += a.getBalance();
		}
		return total;
	}
	
	public double getCombinedBalance() {
		double total = 0;
		total += this.getCheckingBalance();
		total += this.getSavingsBalance();
		total += this.getCDBalance();
		return total;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	
	
	
}





