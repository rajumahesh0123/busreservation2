package com.springboot.busreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.busreservation.model.Bus;

public interface BusRepository extends JpaRepository<Bus,Long> {
	List<Bus> findAll();
	
}
