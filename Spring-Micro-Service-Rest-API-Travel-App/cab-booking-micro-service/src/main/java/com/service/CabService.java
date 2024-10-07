package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Cab;
import com.repository.CabRepository;

@Service
public class CabService {
	
	@Autowired
	CabRepository cabRepository;
	
	public String storeCab(Cab cab) {
		cabRepository.save(cab);
		return "Account Created";
	}
	
	public String updateCab(Cab cab) {
		Optional<Cab> result=cabRepository.findById(cab.getCid());
		if(result.isPresent()) {
			Cab c=result.get();
			c.setTypeofcab(cab.getTypeofcab());
			c.setSeatcapacity(cab.getSeatcapacity());
			c.setFare(cab.getFare());
			cabRepository.saveAndFlush(c);
			return "Cab Information Updated Successfully";
		}else {
			return "Cab Record Not Present";
		}
	}
	
	public String deletecab(int cid) {
		Optional<Cab> result=cabRepository.findById(cid);
		if(result.isPresent()) {
			cabRepository.deleteById(cid);
			return "Cab Record Deleted Successfully";
		}else {
			return "Cab Record Not Present";
		}
	}
	
	public List<Cab> findAllCabs(){
		return cabRepository.findAll();
	}
	
	public Cab findCabById(int cid) {
		Optional<Cab> result=cabRepository.findById(cid);
		if(result.isPresent()) {
			Cab c=result.get();
			return c;
		}else {
			return null;
		}
	}

}
