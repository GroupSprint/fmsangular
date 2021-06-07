package com.cg.flightmgmt.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.FlightScheduleNotFoundException;
import com.cg.flightmgmt.repository.IScheduledFlightRepository;

@Service
@Transactional
public class ScheduledFlightService implements IScheduledFlightService {

	@Autowired
	IScheduledFlightRepository scheduleflightrepository;
	
	// creating logger object
	public static final Logger LOG = LoggerFactory.getLogger(ScheduledFlightService.class);
	
	// implementation of adding scheduled flight 
	@Override
	public ScheduledFlight addFlightSchedule(ScheduledFlight scheduledFlight) {
		LOG.info("ScheduledFlight addFlightSchedule()");
		scheduleflightrepository.saveAndFlush(scheduledFlight);
		return scheduledFlight;
	}
	
	// view scheduled flight by id
	@Override
	public ScheduledFlight viewFlightSchedule(int id) throws FlightScheduleNotFoundException{
		LOG.info("ScheduledFlight viewFlightSchedule()");
		return scheduleflightrepository.findById(id).orElse(null);
	}
	
	// delete scheduled flight by id
	@Override
	public ScheduledFlight removeFlightSchedule(int id) throws FlightScheduleNotFoundException{
		LOG.info("ScheduledFlight removeFlightSchedule()");
		ScheduledFlight f=scheduleflightrepository.findById(id).orElse(null); 
		if(f==null) {
			return null;
		}

		f.setSchedule(null);
		f.setFlight(null);
		scheduleflightrepository.deleteById(id);
		
		return f;
	}
	
	// getting all scheduled glight list
	@Override
	public List<ScheduledFlight> viewAllScheduledFlights() {
		LOG.info("List<ScheduledFlight> viewAllScheduledFlights()");
		List<ScheduledFlight> list=scheduleflightrepository.findAll();
		return list;
	}
	
	// implementation of getting scheduled flight by arrival date 
	@Override
	public List<ScheduledFlight> viewAllScheduledFlights(LocalDateTime arrivaldate) {
		LOG.info("List<ScheduledFlight> viewAllScheduledFlights()");
		List<ScheduledFlight> list=scheduleflightrepository.findAllBySchedule(arrivaldate);
		return list;
	}
	
	// implementation of updating of scheduled flight details
	@Override
	public ScheduledFlight updateFlightSchedule(ScheduledFlight flight) throws FlightScheduleNotFoundException{
		LOG.info("ScheduledFlight updateFlightSchedule()");
		int id=flight.getScheduleFlightId();
		ScheduledFlight flightData=scheduleflightrepository.findById(id).orElse(null);
		if(flightData==null) {
			return null;
		}
		return scheduleflightrepository.save(flight);
	}

//	@Override
//	public List<ScheduledFlight> viewAllScheduledFlightsby(LocalDate date, Airport sairport, Airport dairport) {
//		List<ScheduledFlight> list=scheduleflightrepository.viewAllScheduledFlightsbyAirport(sairport, dairport, date);
//		return list;
//	}
	
	@Override
	public List<ScheduledFlight> viewAllScheduledFlightsbyAirport(String sAirport, String dAirport, LocalDate date1) {
		List<ScheduledFlight> list = scheduleflightrepository.viewAllScheduledFlightsbyAirport(sAirport, dAirport, date1);
		return list;
	}

	
}
