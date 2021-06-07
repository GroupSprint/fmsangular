package com.cg.flightmgmt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.exception.AirportNotFoundException;
import com.cg.flightmgmt.service.IAirportService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/fms/contoller/AirportController")
public class AirportController {
	@Autowired IAirportService airportService;
	
	// Creating Logger Object
	public static final Logger LOG = LoggerFactory.getLogger(AirportController.class);
	
	// Adding Airport by post mapping
	@PostMapping("/addAirport")
	public ResponseEntity<Airport> addAirport(@RequestBody Airport airport)
	{
		LOG.info("ResponseEntity<Airport> addAirport()");
		Airport airport1 = airportService.addAirport(airport);
		return new ResponseEntity<Airport>(airport1, HttpStatus.OK);
	}
	
	// Getting Airport by Id
	@GetMapping("/getAirportById/{id}")
	public ResponseEntity<Airport> viewAirport(@PathVariable int id) throws AirportNotFoundException
	{
		LOG.info("ResponseEntity<Airport> viewAirport()");
		Airport airport = airportService.viewAirport(id);
		if(airport==null)
		{
			throw new AirportNotFoundException("Airport Not Found");
		}
		else
		{
			return new ResponseEntity<Airport>(airport,HttpStatus.OK);
		}
	}
	
	// Getting All Airport List
	@GetMapping("/getAllAirports")
	public ResponseEntity<List<Airport>> viewAllAirports()
	{
		LOG.info("ResponseEntity<List<Airport>> viewAllAirports()");
		List<Airport> list = airportService.viewAirportList();
		return new ResponseEntity<List<Airport>>(list,HttpStatus.OK);
	}
}
