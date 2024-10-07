package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.entity.Booking;
import com.service.BookingService;

@RestController
@RequestMapping("booking") // Base URL for all booking-related endpoints
public class BookingController {

    @Autowired
    BookingService bookingService;

    // Endpoint to add a new booking
    @PostMapping(value = "/add_booking", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addBooking(@RequestBody Booking booking) {
        return bookingService.addBooking(booking);
    }

    // Endpoint to find a booking by its ID
    @GetMapping(value = "/find_booking_by_id/{bid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Booking> findBookingById(@PathVariable("bid") int bid) {
        return bookingService.findBookingById(bid);
    }

    // Endpoint to retrieve cab details by booking ID
    @GetMapping(value = "/find_cab_by_booking_id/{bid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findCabId(@PathVariable("bid") int bid) {
        return bookingService.findCabId(bid);
    }
}
