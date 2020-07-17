package com.project.interviewbooking.data;

import com.project.interviewbooking.model.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByDate(Date date);
}
