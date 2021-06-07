package com.cg.flightmgmt.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Booking {
	@Id
	@GeneratedValue
	private int bookingId;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User userId;
	private LocalDate bookingDate;

	@Digits(fraction = 0, integer = 5)
	private double ticketCost;
	@ManyToOne
	private Flight flight;

	@Max(value = 4)
	@Min(value =1)
	private int noOfPassangers;

	@OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	private List<Passenger> passengerList;

//	@OneToOne
//	private ScheduledFlight scheduledFlight;

	// Default Constructor
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Parameterized Constructor
	public Booking(User userId, LocalDate bookingDate, @Digits(fraction = 0, integer = 5) double ticketCost,
			@Max(4) int noOfPassangers, List<Passenger> passengerList, Flight flight) {
		super();
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.ticketCost = ticketCost;
		this.noOfPassangers = noOfPassangers;
		this.passengerList = passengerList;
		this.flight = flight;
	}

	// Parameterized Constructor
	public Booking(int bookingId, User userId, LocalDate bookingDate,
			@Digits(fraction = 0, integer = 5) double ticketCost, @Max(4) int noOfPassangers,
			List<Passenger> passengerList, Flight flight) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.ticketCost = ticketCost;
		this.noOfPassangers = noOfPassangers;
		this.passengerList = passengerList;
		this.flight = flight;
	}

	
	// Getters and setters
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public int getNoOfPassangers() {
		return noOfPassangers;
	}

	public void setNoOfPassangers(int noOfPassangers) {
		this.noOfPassangers = noOfPassangers;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public double getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", ticketCost=" + ticketCost
				+ ", passengerList=" + passengerList + ", Flight=" + flight + "]";
	}

}
