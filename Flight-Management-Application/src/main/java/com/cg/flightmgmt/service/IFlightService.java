package com.cg.flightmgmt.service;
import java.util.Set;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;

// creating flight service interface
public interface IFlightService {

	public Flight addFlight(Flight flight);
	public Flight viewFlight(int flightno) throws FlightNotFoundException;
	public Set<Flight> viewAllFlights();
	public Flight removeFlight(int flightno) throws FlightNotFoundException;
	public Flight updateFlight(Flight flight) throws FlightNotFoundException;
}
