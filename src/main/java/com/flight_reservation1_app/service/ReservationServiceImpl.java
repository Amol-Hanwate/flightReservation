package com.flight_reservation1_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight_reservation1_app.dto.ReservationRequest;
import com.flight_reservation1_app.entity.Flight;
import com.flight_reservation1_app.entity.Passenger;
import com.flight_reservation1_app.entity.Reservation;
import com.flight_reservation1_app.repository.FlightRepository;
import com.flight_reservation1_app.repository.PassengerRepository;
import com.flight_reservation1_app.repository.ReservationRepository;
import com.flight_reservation1_app.utilities.EmailService;
import com.flight_reservation1_app.utilities.PDFgenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private PDFgenerator pdfGenerator;
	
	@Autowired
	private EmailService emailService;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		

		reservationRepo.save(reservation);
		String filePath = "C:\\Users\\Ankush Raut\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\flight_reservation1_app\\tickets\\reservation"+reservation.getId()+".pdf";

        
		pdfGenerator.generateItinerary(reservation,filePath);
		emailService.sendEmail(passenger.getEmail(), filePath);
		return reservation;
	}

}
