package com.cg.flightmgmt.test.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
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
import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.repository.IPassengerRepository;
import com.cg.flightmgmt.service.PassengerService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class PassengerTest {
	@InjectMocks PassengerService service;
	@Mock IPassengerRepository repo;

	@Test
	public void getPassengerTest()
	{
		Passenger passenger = new Passenger();
		passenger.setPassengerName("Abhishek");
		passenger.setAge(20);
		passenger.getPassengerUIN();
		passenger.setLuggage(213.9);
		Mockito.when(repo.findById(10)).thenReturn(Optional.of(passenger));
		assertThat(service.viewPassenger(10));
	}
	
	@Test
	public void addPassengerTest()
	{
		Passenger p = new Passenger();
		Mockito.when(repo.save(p)).thenReturn(p);
		assertThat(service.addPassenger(p));
	}
	
	@Test
	public void getPassengerList()
	{
		List<Passenger> list = new ArrayList<Passenger>();
		Passenger p1 = new Passenger("Harsh", 22, new BigInteger("123456"), 4.0);
		list.add(p1);
		Mockito.when(repo.findAll()).thenReturn(list);
		assertThat(service.getAllPassengers());
	}
}
