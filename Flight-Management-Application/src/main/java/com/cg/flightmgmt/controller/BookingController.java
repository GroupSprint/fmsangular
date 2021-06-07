package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.service.IFlightBookingService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("fms/controller/bookingController")
public class BookingController {

	@Autowired
	IFlightBookingService bookingService;

	// Creating Logger Object
	public static final Logger LOG = LoggerFactory.getLogger(BookingController.class);

	@PostMapping("/addBooking")
	public ResponseEntity<Booking> addBooking(@Valid @RequestBody Booking booking) {
		LOG.info("ResponseEntity<Booking> addBooking()");
		Booking bookingData = bookingService.addBooking(booking);

		return new ResponseEntity<Booking>(bookingData, HttpStatus.OK);
	}

	// Get Booking By Id
	@GetMapping("/viewBooking/{bid}")
	public ResponseEntity<Booking> viewBooking(@PathVariable int bid) throws BookingNotFoundException {
		LOG.info("ResponseEntity<Booking> viewBooking()");
		Booking bookingData = bookingService.viewBooking(bid);
		if (bookingData == null) {
			throw new BookingNotFoundException("Booking is not found");
		}
		return new ResponseEntity<Booking>(bookingData, HttpStatus.OK);
	}

	// Cancel Booking by id
	@DeleteMapping("/cancelBooking/{bid}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable int bid) throws BookingNotFoundException {
		LOG.info("ResponseEntity<Booking> cancelBooking()");
		Booking bookingData = bookingService.cancelBooking(bid);

		if (bookingData == null) {
			throw new BookingNotFoundException("Booking is not removed");
		}
		bookingData = null;
		return new ResponseEntity<Booking>(bookingData, HttpStatus.OK);
	}

	// View Booking Details By Date
	@GetMapping("/viewBookingByDate")
	public ResponseEntity<List<Booking>> viewBookingByDate(
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		LOG.info("ResponseEntity<List<Booking>> viewBookingByDate()");
		List<Booking> list = bookingService.viewBookingList(date);
		return new ResponseEntity<List<Booking>>(list, HttpStatus.OK);
	}

	// Getting All booking List
	@GetMapping("/getAllBookings")
	public ResponseEntity<List<Booking>> getAllBookings() throws BookingNotFoundException {
		LOG.info("ResponseEntity<Booking> getAllBookings()");
		List<Booking> list = bookingService.getAllBookings();
		return new ResponseEntity<List<Booking>>(list, HttpStatus.OK);
	}

	// Booking List By a User Id
	@GetMapping("/viewBookingListByUserId/{userId}")
	public List<Booking> viewBookingByUserId(@PathVariable BigInteger userId) {
		LOG.info("List<Booking> viewBookingByUserId()");
		return bookingService.viewBookingHistory(userId);
	}

	// Booking List by Flight Id
	@GetMapping("/viewBookingListByFlightId/{flightId}")
	public List<Booking> viewBookingByFlightId(@PathVariable int flightId) {
		LOG.info("List<Booking> viewBookingByFlightId()");
		return bookingService.viewBookingList(flightId);
	}
}
