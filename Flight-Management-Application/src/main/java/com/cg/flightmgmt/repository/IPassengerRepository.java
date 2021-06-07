package com.cg.flightmgmt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.flightmgmt.dto.Passenger;

// Passenger repository
@Repository
public interface IPassengerRepository extends JpaRepository<Passenger,Integer>{

}
