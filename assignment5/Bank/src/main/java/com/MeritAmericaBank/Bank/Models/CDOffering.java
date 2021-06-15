package com.MeritAmericaBank.Bank.Models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


public class CDOffering {
	private int id;
	//@NotBlank(message = "Term is mandatory")
	@Range(min = 1, message = "Term cannot be less than 1" )
	private int term;
	//@NotBlank(message = "Interest rate is mandatory")
	@Min(value = 0, message = "Interest rate must be between 0 and 1")
	@Max(value = 1, message = "Interest rate must be between 0 and 1")
	private double interestRate;
	
	public CDOffering() {
		
	}

	public CDOffering(int term, double interestRate) {
		this.term = term;
		this.interestRate = interestRate;
	}
	
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}