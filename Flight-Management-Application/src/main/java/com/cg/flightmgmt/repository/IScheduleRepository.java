package com.cg.flightmgmt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.flightmgmt.dto.Schedule;

// creating scheduled repository
@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Integer> {

	
}
