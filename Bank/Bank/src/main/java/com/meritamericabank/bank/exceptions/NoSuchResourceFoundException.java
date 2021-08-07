package com.meritamericabank.bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)/*response goes in the exception being thrown instead of the method or else the response would
return in the case of a successful*/
public class NoSuchResourceFoundException extends Exception {
	public NoSuchResourceFoundException(String msg) {
		super(msg);
	}

}
