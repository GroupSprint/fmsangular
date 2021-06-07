package com.cg.flightmgmt.exception;

@SuppressWarnings("serial")
public class BookingNotFoundException extends Exception {
	// creating constructor
	public BookingNotFoundException(String string) {
		super(string);
	}

}
