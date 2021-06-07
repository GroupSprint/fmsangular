package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.repository.IFlightBookingRepository;
import com.cg.flightmgmt.repository.IFlightRepository;

@Service
@Transactional
public class FlightBookingService implements IFlightBookingService {
	@Autowired
	IFlightBookingRepository bookingRepository;
	@Autowired
	IFlightRepository flrepository;

	// Creating logger object
	public static final Logger LOG = LoggerFactory.getLogger(FlightBookingService.class);

	// Adding booking details
	@Override
	public Booking addBooking(Booking booking) {
		LOG.info("Booking addBooking()");
		Booking bookingData = bookingRepository.save(booking);
		return bookingData;
	}

	// view booking by id
	@Override
	public Booking viewBooking(int bookingid) throws BookingNotFoundException {
		LOG.info("Booking viewBooking()");
		return bookingRepository.findById(bookingid).orElse(null);
	}

	// cancel booking by id
	@Override
	public Booking cancelBooking(int bookingid) throws BookingNotFoundException {
		LOG.info("Booking cancelBooking()");
		Booking booking = bookingRepository.findById(bookingid).orElse(null);
		if (booking == null) {
			return null;
		}
		booking.setPassengerList(null);
		bookingRepository.deleteById(bookingid);
		return booking;
	}

	// view all booking details
	@Override
	public List<Booking> viewBookingList(LocalDate bookingdate) {
		LOG.info("List<Booking> viewBookingList()");
		List<Booking> list = bookingRepository.viewBookingList(bookingdate);
		return list;
	}

	// view booking history by user Id
	@Override
	public List<Booking> viewBookingHistory(BigInteger userid) {
		LOG.info("List<Booking> viewBookingHistory()");
		return bookingRepository.viewBookingHistory(userid);
	}

	// get all booking details
	@Override
	public List<Booking> getAllBookings() throws BookingNotFoundException {
		LOG.info("List<Booking> getAllBookings()");
		List<Booking> list = bookingRepository.findAll();
		if (list.size() == 0) {
			throw new BookingNotFoundException("Booking Not Found");
		}
		return list;
	}

	// getting booking details by flight id
	@Override
	public List<Booking> viewBookingList(int flightid) {
		LOG.info("List<Booking> viewBookingList()");
		return bookingRepository.viewBookingList(flightid);
	}
}
