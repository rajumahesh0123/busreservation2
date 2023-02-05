package com.springboot.busreservation.model;

public class JourneyDetails {
	private int customerId; //custoemr table
	//booking details
	private String passengerName;
	private String mobileNumber;
	private String noOfTickets;
	private String busNumber;
	private String source;
	private String destination;
	private String sourceTime;
	private String destinationTime;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
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
	@Override
	public String toString() {
		return "JourneyDetails [customerId=" + customerId + ", passengerName=" + passengerName + ", mobileNumber="
				+ mobileNumber + ", noOfTickets=" + noOfTickets + ", busNumber=" + busNumber + ", source=" + source
				+ ", destination=" + destination + ", sourceTime=" + sourceTime + ", destinationTime=" + destinationTime
				+ "]";
	}
	
	

}
