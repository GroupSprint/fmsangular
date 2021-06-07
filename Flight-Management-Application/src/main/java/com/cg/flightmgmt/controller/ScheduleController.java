package com.cg.flightmgmt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.service.IScheduleService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/fms/ScheduleController")
public class ScheduleController {
	@Autowired IScheduleService scheduleService;
	
	// creating Logger Object
	public static final Logger LOG = LoggerFactory.getLogger(ScheduleController.class);
	
	// Adding Schedule details
	@PostMapping("/addSchedule")
	public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule)
	{
		LOG.info("ResponseEntity<Schedule> addSchedule()");
		Schedule schedule1 = scheduleService.addSchedule(schedule);
		return new ResponseEntity<Schedule>(schedule1, HttpStatus.OK);
	}
	
	// View Schedule By Id
	@GetMapping("/getScheduleById/{id}")
	public ResponseEntity<Schedule> getScheduleById(@PathVariable int id)
	{
		LOG.info("ResponseEntity<Schedule> getScheduleById()");
		Schedule schedule = scheduleService.getScheduleById(id);
		return new ResponseEntity<Schedule>(schedule,HttpStatus.OK); 
	}
	
	// Getting All Schedule List
	@GetMapping("/getAllSchedules")
	public ResponseEntity<List<Schedule>> getScheduleList()
	{
		LOG.info("ResponseEntity<List<Schedule>> getScheduleList()");
		List<Schedule> list = scheduleService.getAllSchedule();
		return new ResponseEntity<List<Schedule>>(list,HttpStatus.OK);
	}
}
