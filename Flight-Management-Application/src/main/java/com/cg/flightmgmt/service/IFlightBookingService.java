package com.cg.flightmgmt.service;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;

// creating flight booking interface
public interface IFlightBookingService {

	public Booking addBooking(Booking booking);
	public Booking cancelBooking(int bookingid) throws BookingNotFoundException;
	public Booking viewBooking(int bookingid) throws BookingNotFoundException;
	public List<Booking> viewBookingList(LocalDate bookingdate);
	public List<Booking> viewBookingList(int flightid);
	public List<Booking> viewBookingHistory(BigInteger userId);
	public List<Booking> getAllBookings() throws BookingNotFoundException;
	
}
