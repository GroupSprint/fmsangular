package com.cg.flightmgmt.exception;

@SuppressWarnings("serial")
public class PassengerNotFoundException extends RuntimeException {
	// creating constructor
	public PassengerNotFoundException(String message) {
		super(message);
	}
}
