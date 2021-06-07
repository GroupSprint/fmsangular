package com.cg.flightmgmt.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.ScheduledFlight;

// Scheduled flight repository
@Repository
public interface IScheduledFlightRepository extends JpaRepository<ScheduledFlight, Integer>{
	@Query(value="select s from ScheduledFlight s where s.schedule.scheduleId IN (select ap.scheduleId from Schedule ap where ap.airrivalTime in (:arrivaldate))")
	public List<ScheduledFlight> findAllBySchedule(LocalDateTime arrivaldate);

	
	@Query(value="select s from ScheduledFlight s where s.schedule.sourceAirport.airportLocation =:sAirport and s.schedule.destinationAirport.airportLocation=:dAirport "
			+ " and s.schdate =:date1")  
	public List<ScheduledFlight> viewAllScheduledFlightsbyAirport(String sAirport, String dAirport, LocalDate date1);

}
