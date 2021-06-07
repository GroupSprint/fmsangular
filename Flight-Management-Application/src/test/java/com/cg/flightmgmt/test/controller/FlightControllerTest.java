package com.cg.flightmgmt.test.controller;

import static org.junit.Assert.assertEquals;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.flightmgmt.controller.FlightController;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.service.FlightService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class FlightControllerTest {
	@InjectMocks
	FlightController control;
   
   @Mock
   FlightService service;
   
   @Test
   public void viewAllFlightsTest()
   {
	   Flight flight = new Flight("Rafael", "RF", 300);
	   Set<Flight> set = new HashSet<Flight>();
		set.add(flight);
		Mockito.when(service.viewAllFlights()).thenReturn(set);
		assertEquals(control.viewAllFlights().getStatusCode(),HttpStatus.OK);
   }
   
   @Test
   public void addFlightTest()
   {
	   Flight flight = new Flight("Rafael", "RF", 300);
	   Mockito.when(service.addFlight(flight)).thenReturn(flight);
	   assertEquals(control.addFlight(flight).getStatusCode(), HttpStatus.OK);
   }
   
   @Test
   public void getFlightByIdTest() throws FlightNotFoundException
   {
	   Flight flight = new Flight();
	   Mockito.when(service.viewFlight(10)).thenReturn(flight);
	   assertEquals(control.viewFlight(10).getStatusCode(), HttpStatus.OK);
   }
   
   @Test
   public void removeFlightTest() throws FlightNotFoundException
   {
	   Flight flight = new Flight();
	   Mockito.when(service.removeFlight(101)).thenReturn(flight);
	   assertEquals(control.removeFlight(101).getStatusCode(), HttpStatus.OK);
   }
   
   @Test
   public void updateFlightTest() throws FlightNotFoundException
   {
	   Flight flight = new Flight("Rafael", "RF", 300);
	   Mockito.when(service.updateFlight(flight)).thenReturn(flight);
	   assertEquals(control.updateFlight(flight).getStatusCode(), HttpStatus.OK);
   }
}
