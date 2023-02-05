package com.springboot.busreservation.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.eclipse.jdt.internal.compiler.util.Sorting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.busreservation.model.Bus;
import com.springboot.busreservation.repository.BusRepository;


@Service
public class BusService implements IBusService{
		
		@Autowired
		private BusRepository busRepo;
		
		
		@Override
		public List<Bus> listAll(){
			List<Bus> busList = busRepo.findAll(Sort.by(Sort.Direction.DESC, "sourceTime"));
			
			return busList;
		}
		
		
		@Override
		public void save(Bus bus) {
			busRepo.save(bus);
		}
		
		@Override
		public void deleteBus(long id) {
			busRepo.deleteById(id);
		}
		
		@Override
		public Optional<Bus> findById(long id) {
			return busRepo.findById(id);
			
		}
		
		
		@Override
		public void updateBus(Bus bus) {
			busRepo.save(bus);
		}


		
		
}

