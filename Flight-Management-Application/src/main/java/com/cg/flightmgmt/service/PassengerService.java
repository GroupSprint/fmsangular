package com.cg.flightmgmt.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.exception.PassengerNotFoundException;
import com.cg.flightmgmt.repository.IPassengerRepository;
@Service
@Transactional
public class PassengerService implements IPassengerService {

	@Autowired
	IPassengerRepository repository;
	
	// creating logger object
	public static final Logger LOG = LoggerFactory.getLogger(PassengerService.class);
	
	// Implementing add passenger method
	@Override
	public Passenger addPassenger(Passenger passenger) {
		LOG.info("Passenger addPassenger()");
		return repository.save(passenger);
	}

	// Implementation of view passenger by id
	@Override
	public Passenger viewPassenger(int passengerId) throws PassengerNotFoundException{
		LOG.info("Passenger viewPassenger()");
		Passenger passengerData=repository.findById(passengerId).orElse(null);
		if(passengerData==null) {
			return null;
		}
		return passengerData;
	}

	// Getting all passenger list
	@Override
	public List<Passenger> getAllPassengers() {
		LOG.info("List<Passenger> getAllPassengers()");
		List<Passenger> list = repository.findAll();
		if(list.size()==0)
		{
			throw new PassengerNotFoundException("No Passenger data available");
		}
		return list;
	}
}
