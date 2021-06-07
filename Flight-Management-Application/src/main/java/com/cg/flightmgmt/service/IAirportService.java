package com.cg.flightmgmt.service;

import java.util.List;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.exception.AirportNotFoundException;

// creating airport interface
public interface IAirportService {
	public Airport addAirport(Airport airport);
	public Airport viewAirport(int id) throws AirportNotFoundException;
	public List<Airport> viewAirportList();
}
