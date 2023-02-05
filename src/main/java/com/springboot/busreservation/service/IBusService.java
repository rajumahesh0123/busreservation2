package com.springboot.busreservation.service;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import com.springboot.busreservation.model.Bus;


public interface IBusService {
	public List<Bus> listAll();
	
	
	public void save(Bus bus) ;
	
	public void deleteBus(long id);
	
	
	public Optional<Bus> findById(long id);
	

	void updateBus(Bus bus);
}