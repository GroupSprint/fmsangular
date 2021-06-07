package com.cg.flightmgmt.test.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.exception.AirportNotFoundException;
import com.cg.flightmgmt.repository.IAirportRepository;
import com.cg.flightmgmt.service.AirportService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AirportTest {
	@InjectMocks AirportService service;
	@Mock IAirportRepository repo;
	
	@Test
	public void viewAirportTest() throws AirportNotFoundException
	{
		Airport airport = new Airport(15, "fff", "Hydrabad");
		Mockito.when(repo.findById(airport.getAirportid())).thenReturn(Optional.of(airport));
		assertThat(service.viewAirport(airport.getAirportid()));
	}
	
	@Test
	public void viewListAirportTest()
	{
		List<Airport> list = new ArrayList<Airport>();
		Mockito.when(repo.findAll()).thenReturn(list);
		assertThat(service.viewAirportList());
	}
	
	@Test
	public void addAirportTest()
	{
		Airport airport = new Airport(15, "fff", "Hydrabad");
		Mockito.when(repo.save(airport)).thenReturn(airport);
		assertThat(service.addAirport(airport));
	}
}
