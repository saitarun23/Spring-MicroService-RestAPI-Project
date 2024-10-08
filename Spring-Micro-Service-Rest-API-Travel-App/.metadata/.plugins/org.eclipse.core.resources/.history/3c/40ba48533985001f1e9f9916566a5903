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

    // Method to add booking and calculate fare based on cab info
    public String addBooking(Booking booking) {
        // Call Cab Microservice to get the cab fare using cid
        String fareUrl = "http://localhost:9090/travel/find_fare_by_cab_id/" + booking.getCid();
        Double fare = restTemplate.getForObject(fareUrl, Double.class);

        if (fare != null) {
            // Calculate the fare based on distance and cab fare per kilometer
            double totalFare = booking.getDistance() * fare;
            booking.setAmount(totalFare);
            bookingRepository.save(booking);
            return "Booking details saved. Total fare: " + totalFare;
        } else {
            return "Cab with ID " + booking.getCid() + " not found.";
        }
    }

    // Method to find a booking by its ID
    public Optional<Booking> findBookingById(int bid) {
        return bookingRepository.findById(bid);
    }

    // Method to retrieve cab details by booking ID
    public String findCabId(int bid) {
        Optional<Booking> result = bookingRepository.findById(bid);
        if (result.isPresent()) {
            Booking booking = result.get();
            String data = restTemplate.getForObject("http://localhost:9090/travel/find_cab_by_id/" + booking.getCid(), String.class);
            return data;
        } else {
            return "Data not present";
        }
    }
}
