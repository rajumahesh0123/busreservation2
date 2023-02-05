package com.springboot.busreservation.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "bus")
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String busNumber;
	
	private String source;
	
	private String destination;
	
	private String sourceTime;
	
	private String destinationTime;
	
	private int noOfSeats=24;
	
	private int fare;
	
	private int availableSeats;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSourceTime() {
		return sourceTime;
	}

	public void setSourceTime(String sourceTime) {
		this.sourceTime = sourceTime;
	}

	public String getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(String destinationTime) {
		this.destinationTime = destinationTime;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}


	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", busNumber=" + busNumber + ", source=" + source + ", destination=" + destination
				+ ", sourceTime=" + sourceTime + ", destinationTime=" + destinationTime + ", noOfSeats=" + noOfSeats
				+ ", fare=" + fare + ", availableSeats=" + availableSeats + "]";
	}
	
	
	
}