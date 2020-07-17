package com.project.interviewbooking.data;

import com.project.interviewbooking.model.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
