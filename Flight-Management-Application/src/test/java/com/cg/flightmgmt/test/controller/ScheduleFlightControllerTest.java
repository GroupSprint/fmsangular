package com.cg.flightmgmt.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
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

import com.cg.flightmgmt.controller.ScheduledFlightController;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.service.ScheduledFlightService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ScheduleFlightControllerTest {
	@InjectMocks ScheduledFlightController control;
	@Mock ScheduledFlightService service;
	
	@Test
	public void addScheduleFlightTest()
	{
		ScheduledFlight sf = new ScheduledFlight();
		Mockito.when(service.addFlightSchedule(sf)).thenReturn(sf);
		assertEquals(control.addScheduledFlight(sf).getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void viewScheduleByIdTest()
	{
		ScheduledFlight sf = new ScheduledFlight();
		Mockito.when(service.viewFlightSchedule(101)).thenReturn(sf);
		assertEquals(control.viewScheduledFlightById(101).getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void deleteScheduleFlightByIdTest()
	{
		ScheduledFlight sf = new ScheduledFlight();
		Mockito.when(service.removeFlightSchedule(101)).thenReturn(sf);
		assertEquals(control.deleteScheduledFlightById(101).getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void viewAllScheduledFlightTest()
	{
		List<ScheduledFlight> sf = new ArrayList<ScheduledFlight>();
		Mockito.when(service.viewAllScheduledFlights()).thenReturn(sf);
		assertEquals(control.viewAllScheduledFlight().getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void updateScheduledFlightTest()
	{
		ScheduledFlight sf = new ScheduledFlight();
		Mockito.when(service.updateFlightSchedule(sf)).thenReturn(sf);
		assertEquals(control.updateScheduledFlight(sf).getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void viewScheduledFlightByDateTest()
	{
		List<ScheduledFlight> sf = new ArrayList<ScheduledFlight>();
		LocalDateTime date = null;
		Mockito.when(service.viewAllScheduledFlights(date)).thenReturn(sf);
		assertEquals(control.viewAllScheduled(date).getStatusCode(), HttpStatus.OK);
	}
}
