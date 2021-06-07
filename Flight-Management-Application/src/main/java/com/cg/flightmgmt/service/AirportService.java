package com.cg.flightmgmt.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.exception.AirportNotFoundException;
import com.cg.flightmgmt.repository.IAirportRepository;

@Service
@Transactional
public class AirportService implements IAirportService{
	
	@Autowired IAirportRepository airportRepository;
	
	// Creating Logger object
	public static final Logger LOG = LoggerFactory.getLogger(AirportService.class);
	
	// view airport by id
	@Override
	public Airport viewAirport(int id) throws AirportNotFoundException {
		LOG.info("Airport viewAirport()");
		Optional<Airport> airport = airportRepository.findById(id);
		if(airport.isPresent())
		{
			return airport.get();
		}
		else
		{
			throw new AirportNotFoundException("Airport not found");
		}
	}

	// getting list of airport
	@Override
	public List<Airport> viewAirportList() {
		LOG.info("List<Airport> viewAirportList()");
		return airportRepository.findAll();
	}

	// adding airport
	@Override
	public Airport addAirport(Airport airport) {
		LOG.info("Airport addAirport()");
		return airportRepository.save(airport);
	}

}
