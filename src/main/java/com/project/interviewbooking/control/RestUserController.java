package com.project.interviewbooking.control;

import com.project.interviewbooking.data.UserRepository;
import com.project.interviewbooking.model.AngularUser;
import com.project.interviewbooking.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class RestUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public List<AngularUser> getAllUsers() {
        List<AngularUser> users = userRepository.findAll().parallelStream().map(user -> new AngularUser(user)).collect(Collectors.toList());
        return users;
    }

    @GetMapping("/{id}")
    public AngularUser getUser(@PathVariable Long id) {
        AngularUser user = new AngularUser(userRepository.findById(id).get());
        return user;
    }

    @PostMapping
    public AngularUser newUser(@RequestBody User user) {
        return new AngularUser(userRepository.save(user));
    }

    @PutMapping()
    public AngularUser updateUser(@RequestBody AngularUser updatedUser) {
        User originalUser = userRepository.findById(updatedUser.getId()).get();
        originalUser.setName(updatedUser.getName());
        return new AngularUser(userRepository.save(originalUser));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
    }

    @GetMapping("/resetPassword/{id}")
    public void resetPassword(@PathVariable("id") Long id){
        User user = userRepository.findById(id).get();
        user.setPassword("reset123");
        userRepository.save(user);
    }
}


