package com.springboot.busreservation.service;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import com.springboot.busreservation.model.BookingData;
import com.springboot.busreservation.model.BookingDetails;

public interface IBookingService {

	List<BookingDetails> getBookingDetails(int custId);
	
	List<BookingData> getBookingDetailsWithBusData(int custId);
	
	List<BookingDetails> getApprovedBookings();
	
	List<BookingDetails> getPendingBookings();
	
	List<BookingDetails> getPendingBookings (int custId);
	
	Optional<BookingDetails> getBookingsById(long id);

	
	void updateBookings(BookingDetails bookingDetails);

	
	void addBookings(BookingDetails bookingDetails);

	void deleteBookings(long id);
	
	void saveBookings(BookingDetails bookingDetails);

	List<String> getBookedSeats(String busId);
	
	int getBookedSeatsCount(long busId);
}