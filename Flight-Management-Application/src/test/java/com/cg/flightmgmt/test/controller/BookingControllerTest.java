package com.cg.flightmgmt.test.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cg.flightmgmt.controller.BookingController;
import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.service.FlightBookingService;



@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BookingControllerTest {

	@InjectMocks
	BookingController control;

	@Mock
	FlightBookingService service;
	
	@Test
	public void addBookingTest()
	{
		BigInteger no=new BigInteger("1");
		BigInteger no1=new BigInteger("123");

		Passenger passenger=new Passenger(100, "xyz", 25,no , 2.5);
		List<Passenger> list=new ArrayList<Passenger>();
		list.add(passenger);
		Airport sairport=new Airport(33,"sss","Indore");
		Airport dairport=new Airport(22,"iii","Karachi");
        LocalDateTime arrival=LocalDateTime.of(2021, Month.MAY, 9, 21, 21, 21, 21);
        LocalDateTime departure=LocalDateTime.of(2021, Month.MAY, 8, 21, 21, 21, 21);
        LocalDate date3=LocalDate.of(2021, 05, 11);
        User user=new User(no1, "cust","Usha","147852","usha@gmail.com","1234567890");
		Schedule sc=new Schedule(555, sairport, dairport, arrival,departure);
		Flight flight=new Flight(147,"Air","ppppp", 1000);
		Booking booking=new Booking(145,user, date3,500, 1,list, flight);
		Mockito.when(service.addBooking(booking)).thenReturn(booking);
		assertEquals(control.addBooking(booking).getStatusCode(),HttpStatus.OK);
	}
	
	@Test
	public void viewBookingTest() throws BookingNotFoundException
	{
		Booking booking=new Booking();
		Mockito.when(service.viewBooking(10)).thenReturn(booking);	
		assertEquals(control.viewBooking(10).getStatusCode(),HttpStatus.OK);	
	}
	
	@Test
	public void cancelBookingTest() throws BookingNotFoundException
	{
		Booking booking=new Booking();
		Mockito.when(service.cancelBooking(10)).thenReturn(booking);	
		assertEquals(control.cancelBooking(10).getStatusCode(),HttpStatus.OK);
		
	}
	@Test
	public void updateBookingTest() throws BookingNotFoundException
	{
		BigInteger no=new BigInteger("2");
		BigInteger no1=new BigInteger("133");

		Passenger passenger=new Passenger(100, "xyz", 25,no , 2.5);
		List<Passenger> list=new ArrayList<Passenger>();
		list.add(passenger);
		Airport sairport=new Airport(33,"sss","karachi");
		Airport dairport=new Airport(22,"iii","Indore");
        LocalDateTime arrival=LocalDateTime.of(2021, Month.MAY, 9, 21, 21, 21, 21);
        LocalDateTime departure=LocalDateTime.of(2021, Month.MAY, 8, 21, 21, 21, 21);
        LocalDate date3=LocalDate.of(2021, 05, 11);
        User user=new User(no1, "cust","Asha","147852","asha@gmail.com","1234567890");
		Schedule sc=new Schedule(555, sairport, dairport, arrival,departure);
		Flight flight=new Flight(147,"vvvvvv","ppppp", 1000);
		Booking booking=new Booking(145,user, date3,500.0, 1,list, flight);
		Mockito.when(service.addBooking(booking)).thenReturn(booking);
		assertEquals(control.addBooking(booking).getStatusCode(),HttpStatus.OK);
		
	}
	
	@Test
	public void viewBookingListTest()
	{
		List<Booking> booking=new ArrayList<Booking>();
        LocalDate date3=LocalDate.of(2021, 05, 11);
		Mockito.when(service.viewBookingList(date3)).thenReturn((List<Booking>)booking);
		assertEquals(control.viewBookingByDate(date3).getStatusCode(),HttpStatus.OK);
		
	}
	
	@Test
	public void viewAllBookingTest() throws BookingNotFoundException {
		
		BigInteger no=new BigInteger("1");
		BigInteger no1=new BigInteger("123");

		Passenger passenger=new Passenger(100, "xyz", 25,no , 2.5);
		List<Passenger> list=new ArrayList<Passenger>();
		list.add(passenger);
		Airport sairport=new Airport(33,"sss","Indore");
		Airport dairport=new Airport(22,"iii","Karachi");
        LocalDateTime arrival=LocalDateTime.of(2021, Month.MAY, 9, 21, 21, 21, 21);
        LocalDateTime departure=LocalDateTime.of(2021, Month.MAY, 8, 21, 21, 21, 21);
        LocalDate date3=LocalDate.of(2021, 05, 11);
        User user=new User(no1, "cust","Usha","147852","usha@gmail.com","1234567890");
		Schedule sc=new Schedule(555, sairport, dairport, arrival,departure);
		Flight flight=new Flight(147,"Air","ppppp", 1000);
		
		Booking booking=new Booking(145,user, date3,500, 1,list, flight);
		List<Booking> list1=new ArrayList<Booking>();
		list1.add(booking);
		Mockito.when(service.getAllBookings()).thenReturn((List<Booking>)list1);
		assertEquals(control.getAllBookings().getStatusCode(),HttpStatus.OK);
	}
		
}
