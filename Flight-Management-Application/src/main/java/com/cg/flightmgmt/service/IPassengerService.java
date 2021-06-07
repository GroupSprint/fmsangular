package com.cg.flightmgmt.service;
import java.util.List;

import com.cg.flightmgmt.dto.Passenger;

// creating passenger service interface
public interface IPassengerService {
	public Passenger addPassenger(Passenger passenger);
	public Passenger viewPassenger(int passenger);
	public List<Passenger> getAllPassengers();
}
