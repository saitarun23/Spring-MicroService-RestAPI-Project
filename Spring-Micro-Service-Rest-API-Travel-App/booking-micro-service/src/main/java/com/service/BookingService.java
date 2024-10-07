package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entity.Booking;
import com.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public String addBooking(Booking booking) {
		bookingRepository.save(booking);
		return "Booking details saved";
	}
	
	public String findCabId(int cid) {
		Optional<Booking> result=bookingRepository.findById(cid);
		if(result.isPresent()) {
			Booking booking=result.get();
			
			String data=restTemplate.getForObject("http://localhost:9090/travel/findCabId/"+booking.getCid(), String.class);
			return data;
		}else {
			return "Data not present";
		}
	}
}
