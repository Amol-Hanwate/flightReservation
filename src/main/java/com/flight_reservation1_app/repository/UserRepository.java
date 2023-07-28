package com.flight_reservation1_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight_reservation1_app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String emailId);
}
