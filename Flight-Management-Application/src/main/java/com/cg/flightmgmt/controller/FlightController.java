package com.cg.flightmgmt.controller;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.service.IFlightService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/fms/controller/flightController")
public class FlightController{
	@Autowired
	IFlightService service;
	
	// Creating Logger Object
	public static final Logger LOG = LoggerFactory.getLogger(FlightController.class);
	
	// Adding flight Details
	@PostMapping("/addFlight")
	public ResponseEntity<Flight> addFlight(@Valid @RequestBody Flight flight){
		LOG.info("ResponseEntity<Flight> addFlight()");
		Flight flightData=service.addFlight(flight);
		return new ResponseEntity<Flight>(flightData,HttpStatus.OK);
		
	}
	
	// Getting flight By Id
	@GetMapping("/viewFlight/{id}")
	public ResponseEntity<Flight> viewFlight(@PathVariable int id) throws FlightNotFoundException{
		LOG.info("ResponseEntity<Flight> viewFlight()");
		Flight flight=service.viewFlight(id);
		if(flight==null) {
			throw new FlightNotFoundException("No Flight is available with the given FlightId " + id);
		}
		return new ResponseEntity<Flight>(flight,HttpStatus.OK);	
	}
	
	// List of All Flights
	@GetMapping("viewAllFlights")
	public ResponseEntity<Set<Flight>> viewAllFlights(){
		LOG.info("ResponseEntity<Set<Flight>> viewAllFlights()");
		Set<Flight> flightList=service.viewAllFlights();
		return new ResponseEntity<Set<Flight>>(flightList,HttpStatus.OK);	
	}
	
	// Deleting flight By Id
	@DeleteMapping("/removeFlight/{id}")
	  public ResponseEntity<Flight> removeFlight(@PathVariable int id) throws FlightNotFoundException{
		LOG.info("ResponseEntity<Flight> removeFlight()");
	 Flight flightData=service.removeFlight(id);
	 if(flightData==null) {
		 throw new FlightNotFoundException("Flight Id not found");
	 }
	 flightData=null;
	 return new ResponseEntity<Flight>(flightData,HttpStatus.OK);
	}
	
	// Updating Flight details
	@PutMapping("/updateFlight")
	public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight) throws FlightNotFoundException {
		LOG.info("ResponseEntity<Flight> updateFlight()");
		Flight flightData = service.updateFlight(flight);
		if(flightData==null) {
			 throw new FlightNotFoundException("Flight Id not found");
		}
		return new ResponseEntity<Flight>(flightData, HttpStatus.OK);
	}
	
}