package com.meritamericabank.bank.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamericabank.bank.exceptions.NoSuchResourceFoundException;
import com.meritamericabank.bank.models.AccountHolder;
import com.meritamericabank.bank.models.CDAccount;
import com.meritamericabank.bank.models.CheckingAccount;
import com.meritamericabank.bank.models.SavingsAccount;

@RestController
public class AccountHolderController {

	Map<Integer, AccountHolder> holders = new HashMap<>();
	AtomicInteger nextAccountId = new AtomicInteger(0);

	@PostMapping("/AccountHolders")
	public ResponseEntity<AccountHolder> create(@Valid @RequestBody AccountHolder holder) {
		int id = nextAccountId.incrementAndGet();
		holder.setAccountId(id);
		holders.put(id, holder);
		return new ResponseEntity<>(holder, HttpStatus.CREATED);
	}

	@GetMapping("/AccountHolders")
	public ResponseEntity getAll() {
		Collection<AccountHolder> list = holders.values();
		return new ResponseEntity(list, HttpStatus.OK);
//		CDOffering[] list = new CDOffering[offerings.size()];
	}



	@GetMapping("/AccountHolders/{id}")
	@ResponseStatus(HttpStatus.OK)
	public AccountHolder getAccountHolder(@PathVariable int id) throws NoSuchResourceFoundException {
		if (id > holders.size()-1) {
			throw new NoSuchResourceFoundException("Invalid id");
		}
		return holders.get(id);
	}

	@PostMapping("/AccountHolders/{id}/CheckingAccounts")
	public CheckingAccount addCheckingAccount(@PathVariable int id, @RequestBody @Valid CheckingAccount checkingAccount) {
		AccountHolder holder = holders.get(id);
		holder.addCheckingAccount(checkingAccount);
		
		return checkingAccount;
	}

	@GetMapping("/AccountHolders/{id}/CheckingAccounts")
	public CheckingAccount[] getCheckingAccount(@PathVariable int id) {
		return holders.get(id).getCheckingAccounts();
	}

	@PostMapping("/AccountHolders/{id}/SavingsAccounts")
	public SavingsAccount addSavingsAccount(@PathVariable int id, @RequestBody @Valid SavingsAccount sa) {
		AccountHolder holder = holders.get(id);
		holder.addSavingsAccount(sa);
		return sa;
	}

	@GetMapping("/AccountHolders/{id}/SavingsAccounts")
	public SavingsAccount[] getSavingsAccount(@PathVariable int id) {
		return holders.get(id).getSavingsAccounts();
		
	}

	
	@PostMapping("/AccountHolders/{id}/CDAccounts")
	public CDAccount addCDAccount(@PathVariable int id, @RequestBody @Valid CDAccount cdAccount) {
		holders.get(id).addCDAccount(cdAccount);
		return cdAccount;
	}

	@GetMapping("/AccountHolders/{id}/CDAccounts")
	public ResponseEntity<CDAccount[]> getCDAccount(@PathVariable int id) {
		
		if (holders.containsKey(id)) {
			CDAccount[] accounts =  holders.get(id).getCDAccounts();
			return new ResponseEntity<>(accounts, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}