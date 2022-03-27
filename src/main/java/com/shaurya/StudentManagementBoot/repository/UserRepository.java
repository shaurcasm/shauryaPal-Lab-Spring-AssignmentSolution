package com.shaurya.StudentManagementBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shaurya.StudentManagementBoot.entity.User;


public interface UserRepository extends JpaRepository<User,Long> {
	
	
	// Using custom query
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User getUserByUsername(String username);
}