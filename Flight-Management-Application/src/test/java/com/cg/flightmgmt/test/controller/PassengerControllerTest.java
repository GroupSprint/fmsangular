package com.cg.flightmgmt.test.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
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

import com.cg.flightmgmt.controller.PassengerController;
import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.service.PassengerService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PassengerControllerTest {
	
	@InjectMocks PassengerController control;
	@Mock PassengerService service;
	
	@Test
	public void addPassengerTest()
	{
		Passenger passenger = new Passenger(1,"Harsh",22,new BigInteger("123456"), 4.2);
		Mockito.when(service.addPassenger(passenger)).thenReturn(passenger);
		assertEquals(control.addPassenger(passenger).getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void getPassengerByIdTest()
	{
		Passenger passenger = new Passenger();
		Mockito.when(service.viewPassenger(10)).thenReturn(passenger);
		assertEquals(control.getPassengerByid(10).getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void viewAllPassengers()
	{
		Passenger passenger = new Passenger(1,"Harsh",22,new BigInteger("123456"), 4.2);
		List<Passenger> list = new ArrayList<Passenger>();
		list.add(passenger);
		Mockito.when(service.getAllPassengers()).thenReturn(list);
		assertEquals(control.getAllPassengers().getStatusCode(), HttpStatus.OK);
	}
}






