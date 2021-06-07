package com.cg.flightmgmt.repository;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.flightmgmt.dto.Booking;

// Flight Repository
@Repository
public interface IFlightBookingRepository extends JpaRepository<Booking, Integer> {
	
	@Query(value="SELECT b FROM Booking b WHERE b.bookingDate IN (:bookingdate)")
	public List<Booking> viewBookingList(LocalDate bookingdate);

	@Query("select booking from Booking booking where booking.flight.flightId =:flightId")
	public List<Booking> viewBookingList(int flightId);
	
	@Query(value = "select b from Booking b where b.userId.userId in (:userid)")
	public List<Booking> viewBookingHistory(BigInteger userid);
}
