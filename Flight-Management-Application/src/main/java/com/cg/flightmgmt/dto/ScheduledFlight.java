package com.cg.flightmgmt.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;

@Entity
public class ScheduledFlight {
	@Id
	@GeneratedValue
	private int scheduleFlightId;
	@Max(value = 199)
	private int availableSeats;
	@Digits(fraction = 0, integer = 5)
	private double fares; // cost per seat
	@OneToOne
	private Schedule schedule;
	@OneToOne
	private Flight flight;
	private LocalDate schdate;

	// constructors
	public ScheduledFlight() {
		super();
	}
	

	public ScheduledFlight(int scheduleFlightId, @Max(199) int availableSeats,
			@Digits(fraction = 0, integer = 5) double fares, Schedule schedule, Flight flight, LocalDate schdate) {
		super();
		this.scheduleFlightId = scheduleFlightId;
		this.availableSeats = availableSeats;
		this.fares = fares;
		this.schedule = schedule;
		this.flight = flight;
		this.schdate = schdate;
	}


	public int getScheduleFlightId() {
		return scheduleFlightId;
	}

	public void setScheduleFlightId(int scheduleFlightId) {
		this.scheduleFlightId = scheduleFlightId;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public double getFares() {
		return fares;
	}

	public void setFares(double fares) {
		this.fares = fares;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public LocalDate getSchdate() {
		return schdate;
	}

	public void setSchdate(LocalDate schdate) {
		this.schdate = schdate;
	}

	@Override
	public String toString() {
		return "ScheduledFlight [scheduleFlightId=" + scheduleFlightId + ", availableSeats=" + availableSeats
				+ ", fares=" + fares + ", schedule=" + schedule + ", flight=" + flight + ", schdate=" + schdate + "]";
	}

	
}
