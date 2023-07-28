package com.flight_reservation1_app.service;

import com.flight_reservation1_app.dto.ReservationRequest;
import com.flight_reservation1_app.entity.Reservation;

public interface ReservationService {

	Reservation bookFlight(ReservationRequest request);
}
