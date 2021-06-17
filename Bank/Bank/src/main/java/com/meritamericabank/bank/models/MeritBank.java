package com.meritamericabank.bank.models;

import java.util.Arrays;
import java.util.Random;

import com.meritamericabank.bank.models.AccountHolder;

public class MeritBank {
	
	private static CDOffering[] cdOfferings = new CDOffering[0];
	private static AccountHolder[] accountHolders = new AccountHolder[0];
	private static long accountNumber = 0;
	
	public static double getTotalBalances() { //meritbank wants to get total balances to get total balances of all account holders
		double total = 0;
		for(AccountHolder a: accountHolders) {
			total += a.getCombinedBalance();
		}
		
		return total;
	}
	
	public static double futureValue(double val, double r, int t) {
		//FV = 100(1+0.01)3 = $101.03
		return val * Math.pow((1 + r), t); //have to do math.pow for exponents in java
	}
	
	public static long getNextAccountNumber() {
		accountNumber++; //since we don't want to return the same account # each time
		return accountNumber;
	}
	
	public static void addAccountHolder(AccountHolder a) {
		AccountHolder[] temp = new AccountHolder[accountHolders.length + 1];
		
		for (int i = 0; i < accountHolders.length; i++) {
			temp[i] = accountHolders[i];
		}
		
		temp[temp.length - 1] = a;
		accountHolders = temp;
	}
	
	public static void addCDOffering(CDOffering a) {
		CDOffering[] temp = new CDOffering[cdOfferings.length + 1];
		
		for (int i = 0; i < cdOfferings.length; i++) {
			temp[i] = cdOfferings[i];
		}
		
		temp[temp.length - 1] = a;
		cdOfferings = temp;
	}
	
	public static AccountHolder[] getAccountHolders() {
		return accountHolders;
	}
	

	public static CDOffering[] getCDOfferings() {
		return cdOfferings;
	}

	public static void setCDOfferings(CDOffering[] cdOfferings) {
		MeritBank.cdOfferings = cdOfferings;
	} 
	public static void clearCDOfferings() {
		cdOfferings = null;
	}
	
	public static CDOffering getBestCDOffering(double amt) {
		CDOffering best = null; //temporary variables
		for(CDOffering o : cdOfferings) {//for loop to look at every cd offering
			if (best == null) {
				best = o;
			}
			if (o.getInterestRate() >= best.getInterestRate()) {
				best = o;
			}
		}
		return best;
		
	}
	public static CDOffering getSecondBestCDOffering(double amt) {
		CDOffering best = getBestCDOffering(amt);
		CDOffering secondBest = null;
		for(CDOffering o : cdOfferings) {
			if(secondBest == null) {
				best = o;
			}
			if (secondBest == best) {
				continue;
			}
			if(o.getInterestRate() >= secondBest.getInterestRate()) {
				secondBest = o;
			}
		}
		return secondBest;
	}
	
}




