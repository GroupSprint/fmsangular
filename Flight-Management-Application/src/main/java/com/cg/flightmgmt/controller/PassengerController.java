package com.cg.flightmgmt.controller;
import java.util.List;
import javax.validation.Valid;

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

import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.exception.PassengerNotFoundException;
import com.cg.flightmgmt.service.IPassengerService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/fms/controller/passengerController")
public class PassengerController {
 
	@Autowired
	IPassengerService service;
	
	// Creating Logger Object
	public static final Logger LOG = LoggerFactory.getLogger(PassengerController.class);
	
	// Adding Passengers
	@PostMapping("/addPassenger")
	public ResponseEntity<Passenger> addPassenger(@Valid @RequestBody Passenger passenger){
		LOG.info("ResponseEntity<Passenger> addPassenger()");
		
		Passenger passengerData=service.addPassenger(passenger);
		return new ResponseEntity<Passenger>(passengerData,HttpStatus.OK);
	}
	
	// Getting Passenger Details by Id
	@GetMapping("/getPassengerByid/{id}")
	public ResponseEntity<Passenger> getPassengerByid(@PathVariable int id) throws PassengerNotFoundException{
		LOG.info("ResponseEntity<Passenger> getPassengerByid()");
		
		Passenger passengerData=service.viewPassenger(id);

        if(passengerData==null) {

            throw new PassengerNotFoundException("Passenger not found");

        }

        return new ResponseEntity<Passenger>(passengerData,HttpStatus.OK);
	}
	
	// Getting All Passengers List
	@GetMapping("/getAllPassenger")
	public ResponseEntity<List<Passenger>> getAllPassengers()
	{
		LOG.info("ResponseEntity<List<Passenger>> getAllPassengers()");
		List<Passenger> passenger = service.getAllPassengers();
		if(passenger==null)
		{
			throw new PassengerNotFoundException("No Passeneger data available");
		}
		return new ResponseEntity<List<Passenger>>(passenger,HttpStatus.OK);
	}
}
