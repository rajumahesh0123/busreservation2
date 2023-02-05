package com.springboot.busreservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_details")
public class BookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	
	private String mobileNumber;
	
	private String noOfTickets;

	private int amount;
	
	private int bookingStatus;
	
	private String busNumber;
	
	private int custID;
	
	private String seatNums;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(String noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	
	
	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getSeatNums() {
		return seatNums;
	}

	public void setSeatNums(String seatNums) {
		this.seatNums = seatNums;
	}

	@Override
	public String toString() {
		return "BookingDetails [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", noOfTickets="
				+ noOfTickets + ", amount=" + amount + ", bookingStatus=" + bookingStatus + ", busNumber=" + busNumber
				+ ", custID=" + custID + ", seatNums=" + seatNums + "]";
	}
	
	
	
	
	
	
	
}