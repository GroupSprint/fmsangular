package com.cg.flightmgmt.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
	// creating constructor
	public UserNotFoundException(String string) {
		super(string);
	}

}
