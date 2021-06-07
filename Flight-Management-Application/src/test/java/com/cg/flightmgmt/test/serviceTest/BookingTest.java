package com.cg.flightmgmt.test.serviceTest;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.math.BigInteger;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.repository.IFlightBookingRepository;
import com.cg.flightmgmt.service.IFlightBookingService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BookingTest {
	@Autowired
	private IFlightBookingService bookingService;
	@MockBean
	IFlightBookingRepository bookingrepository;
	
	static LocalDate date = LocalDate.now();
	
	@Test
	public void testbookingId() {
		final Booking book=new Booking();
//		Id.setBookingId(101);
		book.setBookingDate(LocalDate.of(2020,9,18));
		book.setTicketCost(500);
		book.setNoOfPassangers(5);
		Mockito.when(bookingrepository.save(book)).thenReturn(book);
		assertSame(bookingService.addBooking(book),book);
	}
	@Test
	public void testupdateBooking() throws BookingNotFoundException {
		Booking updateBooking=new Booking();
		equals(updateBooking.getBookingId());
//		updateBooking.setBookingId(101);
		updateBooking.setBookingDate(LocalDate.of(2020,9,18));
		updateBooking.setTicketCost(500);
		updateBooking.setNoOfPassangers(5);
		Mockito.when(bookingrepository.save(updateBooking)).thenReturn(updateBooking);
		assertSame(bookingService.addBooking(updateBooking),updateBooking);
	
	}
	@Test
	public void testcancelBooking() throws BookingNotFoundException {
		Booking booking=new Booking();
		equals(booking.getBookingId());
		BigInteger bookingid = null;
		booking.setBookingId(100);
		booking.setBookingDate(LocalDate.of(2020,9,10));
		booking.setTicketCost(500);
		booking.setNoOfPassangers(4);
		Mockito.when(bookingrepository.save(booking)).thenReturn(booking);
		Assertions.assertDoesNotThrow(()->bookingService.cancelBooking(100));

	}
	
	@Test
	public void testviewBooking() throws BookingNotFoundException {
		Booking booking=new Booking();
		equals(booking.getBookingId());
		booking.setBookingId(102);
		booking.setBookingDate(LocalDate.of(2020,9,18));
		booking.setTicketCost(500);
		booking.setNoOfPassangers(2);
		Mockito.when(bookingrepository.save(booking)).thenReturn(booking);
		assertSame(bookingService.addBooking(booking),booking);
		Assertions.assertDoesNotThrow(()->bookingService.viewBooking(102));
	}

}