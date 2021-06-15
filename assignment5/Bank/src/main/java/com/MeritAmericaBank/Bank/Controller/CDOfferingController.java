package com.MeritAmericaBank.Bank.Controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.MeritAmericaBank.Bank.Models.CDOffering;

@RestController
public class CDOfferingController {
	Map<Integer,CDOffering> offerings = new HashMap<>();
	AtomicInteger nextID = new AtomicInteger(0);
@PostMapping("/CDOfferings")
public ResponseEntity create(@Valid @RequestBody CDOffering offering) {
	int id = nextID.incrementAndGet();
	offering.setId(id);
	offerings.put(id, offering);
	return new ResponseEntity(offering, HttpStatus.CREATED);
}

@GetMapping("/CDOfferings")
public ResponseEntity getAll() {
	Collection list = offerings.values();
	return new ResponseEntity(list, HttpStatus.OK);
//	CDOffering[] list = new CDOffering[offerings.size()];
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
