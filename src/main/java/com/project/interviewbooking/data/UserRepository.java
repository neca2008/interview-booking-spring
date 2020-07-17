package com.project.interviewbooking.data;

import com.project.interviewbooking.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
