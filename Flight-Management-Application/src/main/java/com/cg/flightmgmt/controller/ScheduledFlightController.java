package com.cg.flightmgmt.controller;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.FlightScheduleNotFoundException;
import com.cg.flightmgmt.service.IScheduledFlightService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/fms/controller/scheduledFlightController")
public class ScheduledFlightController {

	@Autowired
	IScheduledFlightService service;
	
	// Creating Logger Object
	public static final Logger LOG = LoggerFactory.getLogger(ScheduledFlightController.class);
	
	// Making Schedule Flight
	@PostMapping("/addScheduledFlight")
	public ResponseEntity<ScheduledFlight> addScheduledFlight(@Valid @RequestBody ScheduledFlight scheduledFlight)
	{
		LOG.info("ResponseEntity<ScheduledFlight> addScheduledFlight()");
		ScheduledFlight scheduledFlightData=service.addFlightSchedule(scheduledFlight);
		return new ResponseEntity<ScheduledFlight>(scheduledFlightData,HttpStatus.OK);
	}
	
	// detail of Schedule flight by id
	@GetMapping("/viewScheduledFlightById/{id}")
	public ResponseEntity<ScheduledFlight> viewScheduledFlightById(@PathVariable int id) throws FlightScheduleNotFoundException{
		LOG.info("ResponseEntity<ScheduledFlight> viewScheduledFlightById()");
		ScheduledFlight scheduledFlightData=service.viewFlightSchedule(id);
		if(scheduledFlightData==null) {
			throw new FlightScheduleNotFoundException("Flight Schedule not Found");
		}
		else
		{
			return new ResponseEntity<ScheduledFlight>(scheduledFlightData,HttpStatus.OK);
		}
	}
	
	// delete schedule flight by id
	@DeleteMapping("/deleteScheduledFlightById/{id}")
	public ResponseEntity<ScheduledFlight> deleteScheduledFlightById(@PathVariable int id) throws FlightScheduleNotFoundException{
		LOG.info("ResponseEntity<ScheduledFlight> deleteScheduledFlightById()");
			ScheduledFlight scheduleFlightData=service.removeFlightSchedule(id);
			if(scheduleFlightData==null) {
				throw new FlightScheduleNotFoundException("Flight Schedule not Found");
			}
		//	scheduleFlightData=null;
			else
			{
				return new ResponseEntity<ScheduledFlight>(scheduleFlightData,HttpStatus.OK);
			}
	}
	
	// Getting All scheduled Flight list
	@GetMapping("/viewAllScheduledFlight")
	public ResponseEntity<List<ScheduledFlight>> viewAllScheduledFlight(){
		LOG.info("ResponseEntity<ScheduledFlight> viewAllScheduledFlight()");
		List<ScheduledFlight> scheduledFlightData=service.viewAllScheduledFlights();
		return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightData,HttpStatus.OK);
	}
	
	// updating scheduled flight details
	@PutMapping("/updateScheduledFlight")
	public ResponseEntity<ScheduledFlight> updateScheduledFlight(@Valid @RequestBody ScheduledFlight scheduledFlight) throws FlightScheduleNotFoundException{
		LOG.info("ResponseEntity<ScheduledFlight> updateScheduledFlight()");
		ScheduledFlight scheduledFlightData=service.updateFlightSchedule(scheduledFlight);
		if(scheduledFlightData==null) {
			throw new FlightScheduleNotFoundException("Flight Schedule not Found");
		}
		else
		{
			return new ResponseEntity<ScheduledFlight>(scheduledFlightData,HttpStatus.OK);
		}
	}
	
	// scheduled flight by date
	@GetMapping("/viewAllScheduleByDate")
	public ResponseEntity<List<ScheduledFlight>> viewAllScheduled(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){
		LOG.info("ResponseEntity<ScheduledFlight> viewAllScheduled()");
		List<ScheduledFlight> scheduledFlightData=service.viewAllScheduledFlights(date);
		return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightData,HttpStatus.OK);
	}
	

	@GetMapping("/viewAllScheduledFlightByAirport/{sAirport}/{dAirport}/{date1}")
	//public ResponseEntity<List<ScheduledFlight>> viewAllScheduledFlightsbyAirport(@PathVariable String sAirport, @PathVariable String dAirport,@RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1){
	public ResponseEntity<List<ScheduledFlight>> viewAllScheduledFlightsbyAirport(@PathVariable String sAirport, @PathVariable String dAirport,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1){

		LOG.info("ResponseEntity<ScheduledFlight> viewAllScheduledFlightsbyAirport()");
		List<ScheduledFlight> scheduledFlightData=service.viewAllScheduledFlightsbyAirport(sAirport, dAirport, date1);
		return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightData,HttpStatus.OK);
	}
}
