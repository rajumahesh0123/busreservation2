package com.springboot.busreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.busreservation.model.BookingDetails;


public interface BookingRepository extends JpaRepository<BookingDetails, Long>{
	List<BookingDetails> findAll();
	
	@Query(value = "select distinct ifnull(group_concat(seat_nums),0) from booking_details where bus_number= (:busNum)", nativeQuery = true)
	String findSeatNums(@Param("busNum") String busNum);
	
	@Query(value = "select ifnull(sum(no_of_tickets),0) from booking_details where bus_number= (:busNum)", nativeQuery = true)
	int getBookedSeatsCount(@Param("busNum") long busNum);
	
	
}
