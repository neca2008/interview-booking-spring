package com.project.interviewbooking.services;

import com.project.interviewbooking.data.BookingRepository;
import com.project.interviewbooking.data.RoomRepository;
import com.project.interviewbooking.data.UserRepository;
import com.project.interviewbooking.model.Layout;
import com.project.interviewbooking.model.entities.Booking;
import com.project.interviewbooking.model.entities.LayoutCapacity;
import com.project.interviewbooking.model.entities.Room;
import com.project.interviewbooking.model.entities.User;
import com.project.interviewbooking.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataInitialization {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookingRepository bookingRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        List<Room> rooms = roomRepository.findAll();
        if (rooms.size() == 0) {
            Room conferenceRoom = new Room("Conference Room","1st Floor");
            conferenceRoom.setCapacity(new LayoutCapacity(Layout.BOARD,8));
            conferenceRoom.setCapacity(new LayoutCapacity(Layout.THEATER,16));
            roomRepository.save(conferenceRoom);

            Room teamMeetingRoom = new Room("Team Meeting Room","2nd Floor");
            teamMeetingRoom.setCapacity(new LayoutCapacity(Layout.BOARD,12));
            teamMeetingRoom.setCapacity(new LayoutCapacity(Layout.USHAPE,26));
            roomRepository.save(teamMeetingRoom);

            Room guestRoom = new Room("Guest Room","1st Floor");
            guestRoom.setCapacity(new LayoutCapacity(Layout.THEATER,80));
            guestRoom.setCapacity(new LayoutCapacity(Layout.USHAPE,40));
            roomRepository.save(guestRoom);

            User user = new User("Ines", "secret");
            userRepository.save(user);

            User user2 = new User("Sonja", "secret");
            userRepository.save(user2);

            User user3 = new User("Florian", "secret");
            userRepository.save(user3);

            User user4 = new User("Markus", "secret");
            userRepository.save(user4);

            Booking booking1 = new Booking();
            booking1.setDate(new java.sql.Date(new java.util.Date().getTime()));
            booking1.setStartTime(java.sql.Time.valueOf("15:15:00"));
            booking1.setEndTime(java.sql.Time.valueOf("16:15:00"));
            booking1.setLayout(Layout.USHAPE);
            booking1.setParticipants(3);
            booking1.setTitle("Conference call with Ines");
            booking1.setRoom(conferenceRoom);
            booking1.setUser(user2);
            bookingRepository.save(booking1);

            Booking booking2 = new Booking();
            booking2.setDate(new java.sql.Date(new java.util.Date().getTime()));
            booking2.setStartTime(java.sql.Time.valueOf("17:00:00"));
            booking2.setEndTime(java.sql.Time.valueOf("17:30:00"));
            booking2.setLayout(Layout.BOARD);
            booking2.setParticipants(5);
            booking2.setTitle("HR Update");
            booking2.setRoom(teamMeetingRoom);
            booking2.setUser(user3);
            bookingRepository.save(booking2);
        }
    }
}
