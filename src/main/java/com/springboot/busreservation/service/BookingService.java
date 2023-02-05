package com.springboot.busreservation.service;


import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.busreservation.repository.BusRepository;
import com.springboot.busreservation.model.BookingData;
import com.springboot.busreservation.model.BookingDetails;
import com.springboot.busreservation.model.Bus;
import com.springboot.busreservation.model.JourneyDetails;
import com.springboot.busreservation.repository.BookingRepository;

@Service
public class BookingService implements IBookingService {

	@Autowired
	private BookingRepository bookingRepo;
   
	@Autowired
	private BusRepository busRepo;

	@Autowired
	IBusService busService;
	
	@Override
	public List<BookingDetails> getBookingDetails(int custId) {
		// TODO Auto-generated method stub
		List<BookingDetails> bookingDetails = new ArrayList<>();
		for (BookingDetails b: bookingRepo.findAll()) {
			if (b.getCustID()==custId) {
				bookingDetails.add(b);
			}
		}
		return bookingDetails;
	}
	
	@Override
	public List<BookingData> getBookingDetailsWithBusData(int custId){
		//get the details of bus as well and store it in busNUmber variable
		
		List<BookingData> bookingData = new ArrayList<>();
		for (BookingDetails b: bookingRepo.findAll()) {
			if (b.getCustID() == custId) {
				BookingData bd = new BookingData();
				bd.setId(b.getId());
				bd.setAmount(b.getAmount());
				bd.setBookingStatus(b.getBookingStatus());
				bd.setCustID(custId);
				Bus bus = busService.findById(Integer.parseInt(b.getBusNumber())).get();
				bd.setDestination(bus.getDestination());
				bd.setSource(bus.getSource());
				bd.setJourneyDate(bus.getSourceTime());
				bd.setMobileNumber(b.getMobileNumber());
				bd.setName(b.getName());
				bd.setNoOfTickets(b.getNoOfTickets());
				bd.setSeatNums(b.getSeatNums());
				bookingData.add(bd);
			}
		}
		bookingData.sort(Comparator.comparing(BookingData::getJourneyDate, Comparator.nullsLast(Comparator.reverseOrder())));
		return bookingData;
	}

	@Override
	public List<BookingDetails> getApprovedBookings() {
		List<BookingDetails> bookingDetails = new ArrayList<>();
		for (BookingDetails b: bookingRepo.findAll()) {
			if (b.getBookingStatus()==3) {
				System.out.println("busNumber3: " +  b.getBusNumber());
				bookingDetails.add(b);
			}
		}
		return bookingDetails;
	}
	@Override
	public List<BookingDetails> getPendingBookings () {
		// TODO Auto-generated method stub
		List<BookingDetails> bookingDetails = new ArrayList<>();
		for (BookingDetails b: bookingRepo.findAll()) {
			if (b.getBookingStatus()==2) {
				System.out.println("busNumber2: " +  b.getBusNumber());
				b.setBusNumber(b.getBusNumber() + ", " + busService.findById(Integer.parseInt(b.getBusNumber())).get().getAvailableSeats());
				bookingDetails.add(b);
			}
		}
		return bookingDetails;
	}

	@Override
	public List<BookingDetails> getPendingBookings (int custId) {
		// TODO Auto-generated method stub
		List<BookingDetails> bookingDetails = new ArrayList<>();
		for (BookingDetails b: bookingRepo.findAll()) {
			if (b.getCustID()==custId && b.getBookingStatus()==0) {
				bookingDetails.add(b);
			}
		}

		return bookingDetails;
	}

	@Override
	public Optional<BookingDetails> getBookingsById(long id) {
		// TODO Auto-generated method stub
		return bookingRepo.findById(id);
	}

	@Override
	public void updateBookings(BookingDetails bookingDetails) {
		bookingRepo.save(bookingDetails);
		
	}

	@Override
	public void addBookings(BookingDetails bookingDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBookings(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveBookings(BookingDetails bookingDetails) {
		bookingRepo.save(bookingDetails);
		
	}
	
	@Override
	public List<String> getBookedSeats(String busId){
		List<String> list = new ArrayList<>();
		for ( String seats: bookingRepo.findSeatNums(busId).split(",")) {
			list.add(seats);
		}
		return list;
	}
	
	@Override
	public int getBookedSeatsCount(long busId) {		
		return bookingRepo.getBookedSeatsCount(busId);

	}
}