package com.project.interviewbooking.control;

import com.project.interviewbooking.data.RoomRepository;
import com.project.interviewbooking.model.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RestRoomController {
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Room> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        return rooms;
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable("id") Long id) {
        Room room = roomRepository.findById(id).get();

        return room;
    }

    @PostMapping()
    public Room newRoom(@RequestBody Room room) {
        return roomRepository.save(room);
    }

    @PutMapping()
    public Room updateRoom(@RequestBody Room updatedRoom) {
        Room originalRoom = roomRepository.findById(updatedRoom.getId()).get();
        originalRoom.setName(updatedRoom.getName());
        originalRoom.setLocation(updatedRoom.getLocation());
        originalRoom.setCapacities(updatedRoom.getCapacities());

        return roomRepository.save(originalRoom);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable("id") Long id){
        roomRepository.deleteById(id);
    }
}

