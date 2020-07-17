package com.project.interviewbooking.control;

import com.project.interviewbooking.data.BookingRepository;
import com.project.interviewbooking.model.entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class RestBookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/{date}")
    public List<Booking> getBookingsByDate(@PathVariable("date") String date) {
        Date sqlDate = Date.valueOf(date);
        return bookingRepository.findAllByDate(sqlDate);
    }

    @GetMapping()
    public Booking getBookingById(@RequestParam("id") Long id) {
        return bookingRepository.findById(id).get();
    }

    @PostMapping()
    public Booking newBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return booking;
    }

    @PutMapping()
    public Booking updateBooking(@RequestBody Booking updatedBooking) {
        bookingRepository.save(updatedBooking);
        return updatedBooking;
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable("id") Long id) {
        bookingRepository.deleteById(id);
    }
}

