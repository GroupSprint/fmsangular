package com.cg.flightmgmt.test.controller;
import static org.junit.Assert.assertEquals;
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
import com.cg.flightmgmt.controller.AirportController;
import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.exception.AirportNotFoundException;
import com.cg.flightmgmt.service.AirportService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AirportControllerTest {

	@InjectMocks
	AirportController control;

	@Mock
	AirportService service;

	@Test
	public void addAirportTest() {
		Airport airport = new Airport(15, "fff", "Hydrabad");
		Mockito.when(service.addAirport(airport)).thenReturn(airport);
		assertEquals(control.addAirport(airport).getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void viewAllAirportTest() {
		Airport airport = new Airport(12, "zzz", "Delhi");
		List<Airport> list = new ArrayList<Airport>();
		list.add(airport);
		Mockito.when(service.viewAirportList()).thenReturn((List<Airport>) list);
		assertEquals(control.viewAllAirports().getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void getAirportByIdTest() throws AirportNotFoundException {
		Airport airport = new Airport();
		Mockito.when(service.viewAirport(15)).thenReturn(airport);
		assertEquals(control.viewAirport(15).getStatusCode(), HttpStatus.OK);
	}	
}
