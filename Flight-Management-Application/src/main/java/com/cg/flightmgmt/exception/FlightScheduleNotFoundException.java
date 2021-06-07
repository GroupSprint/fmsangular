package com.cg.flightmgmt.exception;

@SuppressWarnings("serial")
public class FlightScheduleNotFoundException extends RuntimeException {
	// creating constructor
	public FlightScheduleNotFoundException(String message) {
		super(message);
	}
}
