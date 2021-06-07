package com.cg.flightmgmt.test.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.repository.IScheduleRepository;
import com.cg.flightmgmt.service.ScheduleService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ScheduleTest {
	@Mock
	IScheduleRepository repo;
	@InjectMocks
	ScheduleService service;
	
	@Test
	public void addScheduleTest() {
		Airport airport = new Airport(15, "fff", "Hydrabad");
		Airport airport1 = new Airport(17, "fdx", "Pune");
		Schedule sc = new Schedule(1,airport,airport1,LocalDateTime.of(2021,05,23,19,22),LocalDateTime.of(2021,05,23,19,22));
		Mockito.when(repo.save(sc)).thenReturn(sc);
		Assertions.assertEquals(sc,service.addSchedule(sc)); 
		}
	
	@Test
	public void getScheduleByIdTest() {
		Airport airport = new Airport(15, "fff", "Hydrabad");
		Airport airport1 = new Airport(17, "fdx", "Pune");
		Schedule sc = new Schedule(1,airport,airport1,LocalDateTime.of(2021,05,23,19,22),LocalDateTime.of(2021,05,23,19,22));
		Mockito.when(repo.findById(1)).thenReturn(Optional.of(sc));
		 assertThat(service.getScheduleById(1)).isEqualTo(sc);	
	}
	@Test
	public void getAllScheduleTest() {
		Airport airport = new Airport(15, "fff", "Hydrabad");
		Airport airport1 = new Airport(17, "fdx", "Pune");
		Schedule sc = new Schedule(1,airport,airport1,LocalDateTime.of(2021,05,23,19,22),LocalDateTime.of(2021,05,23,19,22));
		Schedule sc1 = new Schedule(2,airport1,airport,LocalDateTime.of(2021,05,25,19,22),LocalDateTime.of(2021,05,27,19,22));
		List<Schedule> mocklist=new ArrayList<Schedule>();
		mocklist.add(sc1);
		mocklist.add(sc);
		Mockito.when(repo.findAll()).thenReturn(mocklist);
		List<Schedule> schedulelist = service.getAllSchedule();
		assertNotNull(schedulelist);
	}
	}
