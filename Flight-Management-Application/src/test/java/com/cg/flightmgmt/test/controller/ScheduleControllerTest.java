package com.cg.flightmgmt.test.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.flightmgmt.controller.ScheduleController;
import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.service.ScheduleService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ScheduleControllerTest {
	
	@InjectMocks
	ScheduleController control;
	
	@Mock
	 ScheduleService service;
	@Test
	public void addScheduleTest() {
		Airport airport = new Airport(15, "fff", "Hydrabad");
		Airport airport1 = new Airport(17, "fdx", "Pune");
		Schedule sc = new Schedule(1,airport,airport1,LocalDateTime.of(2021,05,23,19,22),LocalDateTime.of(2021,05,23,19,22));
		Mockito.when(service.addSchedule(sc)).thenReturn(sc);
		Assertions.assertEquals(control.addSchedule(sc).getStatusCode(),HttpStatus.OK);
		
	}
	@Test
	public void getScheduleByIdTest() {
		Airport airport = new Airport(15, "fff", "Hydrabad");
		Schedule sc = new Schedule(1,airport,airport,LocalDateTime.of(2021,05,23,19,22),LocalDateTime.of(2021,05,23,19,22));
		Mockito.when(service.getScheduleById(sc.getScheduleId())).thenReturn(sc);
		Assertions.assertEquals(control.getScheduleById(sc.getScheduleId()).getStatusCode(),HttpStatus.OK);
	}
	@Test
	public void getAllScheduleTest() {
		Airport airport = new Airport(15, "fff", "Hydrabad");
		Schedule sc = new Schedule(1,airport,airport,LocalDateTime.of(2021,05,23,19,22),LocalDateTime.of(2021,05,23,19,22));
		Airport airport1 = new Airport(16, "fdc", "Mumbai");
		Schedule sc2 = new Schedule(16,airport1,airport1,LocalDateTime.of(2021,05,23,18,22),LocalDateTime.of(2021,04,24,19,22));
		List<Schedule> sc3 = new ArrayList<Schedule>();
		sc3.add(sc2);
		sc3.add(sc);
		Mockito.when(service.getAllSchedule()).thenReturn(sc3);
		Assertions.assertEquals(control.getScheduleList().getStatusCode(),HttpStatus.OK);
	}
}