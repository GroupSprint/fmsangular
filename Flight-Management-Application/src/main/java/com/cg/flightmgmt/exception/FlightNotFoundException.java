package com.cg.flightmgmt.exception;

@SuppressWarnings("serial")
public class FlightNotFoundException extends Exception {
	// creating constructor
	public FlightNotFoundException(String string) {
		super(string);
	}

}
