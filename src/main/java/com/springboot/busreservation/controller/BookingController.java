package com.springboot.busreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.busreservation.model.BookingDetails;
import com.springboot.busreservation.model.Bus;
import com.springboot.busreservation.service.IBookingService;
import com.springboot.busreservation.service.IBusService;

@RestController
public class BookingController {
	
	@Autowired
	IBusService busService;
	
	@Autowired
	IBookingService bookingService;
	
	
	@RequestMapping("/check")
	public String checkMs() {
		System.out.println("ok checking");
		return "ok checking";
	}

	
	@GetMapping("/cancel-ticket/{id}")
	public String cancelBooking(@PathVariable("id") long id) {
		System.out.println("cancel ticket, inside 2");
		BookingDetails bookingDetails = bookingService.getBookingsById(id).get();
		bookingDetails.setBookingStatus(1);
		bookingService.updateBookings(bookingDetails);
		
		return "success";
	}
	
	@GetMapping("/update-paymentstatus/{id}")
	public String updatePaymentStatus(@PathVariable("id") long id) {
		System.out.println("update payment status, inside 2");
		BookingDetails bookingDetails = bookingService.getBookingsById(id).get();
		bookingDetails.setBookingStatus(2);
		bookingService.updateBookings(bookingDetails);
		
		return "success";
	}
	
	@GetMapping("/approve-booking/{id}")
	public String approvePaymentStatus(@PathVariable("id") long id) {
		System.out.println("update approve booking, inside 2");
		BookingDetails bookingDetails = bookingService.getBookingsById(id).get();
		bookingDetails.setBookingStatus(3);
		
		bookingService.updateBookings(bookingDetails);
		Bus bus = busService.findById(Integer.parseInt(bookingDetails.getBusNumber())).get();
		bus.setAvailableSeats(bus.getAvailableSeats()-Integer.parseInt(bookingDetails.getNoOfTickets()));
		busService.updateBus(bus);
		return "success";
	}
}
