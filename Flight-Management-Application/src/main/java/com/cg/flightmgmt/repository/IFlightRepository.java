package com.cg.flightmgmt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.flightmgmt.dto.Flight;

// Flight Repository
@Repository
public interface IFlightRepository extends JpaRepository<Flight, Integer>{
	
}
