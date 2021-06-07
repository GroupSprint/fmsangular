package com.cg.flightmgmt.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.repository.IScheduleRepository;

@Service
@Transactional
public class ScheduleService implements IScheduleService{
	@Autowired IScheduleRepository scheduleRepository;
	
	// creating logger object
	public static final Logger LOG = LoggerFactory.getLogger(ScheduleService.class);
	
	// implementation of adding schedule method
	@Override
	public Schedule addSchedule(Schedule schedule) {
		LOG.info("Schedule addSchedule()");
		return scheduleRepository.save(schedule);
	}

	// implementation of getting schedule by id
	@Override
	public Schedule getScheduleById(int id) {
		LOG.info("Schedule getScheduleById()");
		Optional<Schedule> schedule = scheduleRepository.findById(id);
		return schedule.get();
	}

	// implementation of getting list of all scheduled
	@Override
	public List<Schedule> getAllSchedule() {
		LOG.info("List<Schedule> getAllSchedule()");
		List<Schedule> schedule = scheduleRepository.findAll();
		return schedule;
	}

}
