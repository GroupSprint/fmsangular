package com.cg.flightmgmt.service;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.repository.IFlightRepository;
@Service
@Transactional
public class FlightService implements IFlightService {

	@Autowired
    IFlightRepository flightrepository;
	
	// creating logger object
	public static final Logger LOG = LoggerFactory.getLogger(FlightService.class);
	
	// Adding flight details
	@Override
	public Flight addFlight(Flight flight) {
		LOG.info("Flight addFlight()");
		Flight flightData=flightrepository.save(flight);
		return flightData;
	}

	// View flight details by flight id
	@Override
	public Flight viewFlight(int flightno) throws FlightNotFoundException {
		LOG.info("Flight viewFlight()");
		Optional<Flight> flight = flightrepository.findById(flightno);
		if(flight.isPresent())
		{
			return flight.get();
		}
		else
		{
			throw new FlightNotFoundException("Flight not found");
		}	
	}

	// view All flight list
	@Override
	public Set<Flight> viewAllFlights() {
		LOG.info("Set<Flight> viewAllFligts()");
		Set<Flight> flight=new HashSet<Flight>();
		flightrepository.findAll().forEach(flight1->flight.add(flight1));
		return flight;
	}

	// delete flight details by id
	@Override
	public Flight removeFlight(int flightno) throws FlightNotFoundException {
		LOG.info("Flight removeFlight()");
		Flight flight=flightrepository.findById(flightno).orElse(null);
		if(flight==null) {
		return null;}
		else
		{
			flightrepository.deleteById(flightno);
			return flight;
		}	
	}

	// updating flight details
	@Override
	public Flight updateFlight(Flight flight) throws FlightNotFoundException {
		LOG.info("Flight upadteFlight()");
		int flightId=flight.getFlightId();
		Flight flight1=flightrepository.findById(flightId).orElse(null);
		if(flight1==null) {
			return null;
		}
		else
		{
			Flight flightData=flightrepository.save(flight);
			return flightData;
		}
		
	}
	
}
