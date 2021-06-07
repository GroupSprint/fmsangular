package com.cg.flightmgmt.test.serviceTest;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.repository.IFlightRepository;
import com.cg.flightmgmt.service.IFlightService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class FlightTest {
	@Autowired
	private IFlightService flightservice;
	@MockBean
	IFlightRepository flightrepository;
	@Test
	void contextLoad() {
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private Flight getFlight() {
		Flight flight=new Flight();
		equals(flight.getFlightId());
		flight.setCarrierName("SpiceJet");
		flight.setFlightModel("AUI89");
		flight.setSeatCapacity(200);
		return flight;
	}
	
	@Test
	public void testaddFlight() {
		Flight flight=getFlight();
		when(flightrepository.save(flight)).thenReturn(flight);
		assertSame(flightservice.addFlight(flight),flight);	
	}
	
	@Test
	public void testviewFlight() throws FlightNotFoundException{
		assertThrows(FlightNotFoundException.class, () -> flightservice.viewFlight(5));
	}
	
	@Test
	public void testviewAllFlights() {
	//	Flight flight=getFlight();
		flightservice.viewAllFlights();
		verify(flightrepository,times(1)).findAll();		
	}
	
	
	@Test
	public void updateFlightValidTest() throws FlightNotFoundException{

		Flight updateFlight=new Flight();
		updateFlight.setFlightId(10);
		Mockito.when(flightrepository.findById(10)).thenReturn(Optional.of(updateFlight));
		
		Mockito.when(flightrepository.save(updateFlight)).thenReturn(updateFlight);
		Assertions.assertDoesNotThrow(()->flightservice.updateFlight(updateFlight));

	}
	
	@Test
	public void removeFlightValidTest() {
		Flight flight=new Flight();
		flight.setFlightId(10);
		Mockito.when(flightrepository.findById(10)).thenReturn(Optional.of(flight));
		Assertions.assertDoesNotThrow(()->flightservice.removeFlight(10));
		
	}
}
