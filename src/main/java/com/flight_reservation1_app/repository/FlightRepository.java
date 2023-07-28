package com.flight_reservation1_app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flight_reservation1_app.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight,Long> {

	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to,@Param("dateOfDeparture") Date departureDate);

//	@Query("FROM Flight WHERE LOWER(departureCity) = LOWER(:departureCity) AND LOWER(arrivalCity) = LOWER(:arrivalCity) AND dateOfDeparture = :dateOfDeparture")
//	List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to, @Param("dateOfDeparture") Date departureDate);

}
