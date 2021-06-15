package com.MeritAmericaBank.Bank.Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.MeritAmericaBank.Bank.Models.AccountHolder;
import com.MeritAmericaBank.Bank.Models.CDOffering;

@RestController
public class AccountHolderController {
		Map<Integer,AccountHolder> holders = new HashMap<>();
		AtomicInteger nextSSN = new AtomicInteger(0);
	@PostMapping("/AccountHolders")
	public ResponseEntity create(@Valid @RequestBody AccountHolder holder) {
		int ssn  = nextSSN.incrementAndGet();
		holder.setSSN(ssn);
		holders.put(ssn, holder);
		return new ResponseEntity(holder, HttpStatus.CREATED);
	}

	@GetMapping("/AccountHolders")
	public ResponseEntity getAll() {
		Collection list = holders.values();
		return new ResponseEntity(list, HttpStatus.OK);
//		CDOffering[] list = new CDOffering[offerings.size()];
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions (
	        MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}



	}
