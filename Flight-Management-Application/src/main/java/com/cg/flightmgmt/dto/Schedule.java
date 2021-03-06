package com.cg.flightmgmt.dto;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Schedule {
	@Id
	@GeneratedValue
	private int scheduleId;
	private LocalDateTime airrivalTime;
	private LocalDateTime departureTime;

	@OneToOne(mappedBy = "schedule")
	ScheduledFlight scheduledFlight;

	@OneToOne
	private Airport sourceAirport;

	@OneToOne
	private Airport destinationAirport;

	// Parameterized constructor
	public Schedule(int scheduleId, Airport sourceAirport, Airport destinationAirport, LocalDateTime airrivalTime,
			LocalDateTime departureTime) {
		super();
		this.scheduleId = scheduleId;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.airrivalTime = airrivalTime;
		this.departureTime = departureTime;
	}

	// Parameterized constructor
	public Schedule(Airport sourceAirport, Airport destinationAirport, LocalDateTime airrivalTime,
			LocalDateTime departureTime) {
		super();
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.airrivalTime = airrivalTime;
		this.departureTime = departureTime;
	}

	// default constructor
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public LocalDateTime getAirrivalTime() {
		return airrivalTime;
	}

	public void setAirrivalTime(LocalDateTime airrivalTime) {
		this.airrivalTime = airrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", sourceAirport=" + sourceAirport + ", destinationAirport="
				+ destinationAirport + ", airrivalTime=" + airrivalTime + ", departureTime=" + departureTime + "]";
	}

}
