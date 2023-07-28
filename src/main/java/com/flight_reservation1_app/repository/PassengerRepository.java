package com.flight_reservation1_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight_reservation1_app.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
