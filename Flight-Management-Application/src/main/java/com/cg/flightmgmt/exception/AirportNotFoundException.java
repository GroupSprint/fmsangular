package com.cg.flightmgmt.exception;

@SuppressWarnings("serial")
public class AirportNotFoundException extends Exception {
	// creating constructor
	public AirportNotFoundException(String message)
	{
		super(message);
	}
}
