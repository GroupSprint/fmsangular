package com.cg.flightmgmt.service;

import java.util.List;

import com.cg.flightmgmt.dto.Schedule;

//creating schedule service interface
public interface IScheduleService {
	public Schedule addSchedule(Schedule schedule);
	public Schedule getScheduleById(int id);
	public List<Schedule> getAllSchedule();
}
