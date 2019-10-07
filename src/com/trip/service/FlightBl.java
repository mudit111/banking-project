package com.trip.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Flight;

public interface FlightBl {

	boolean addFlight(Flight flight);

	List<Flight> getFlights(String flightOrigin, String flightDestination, LocalDate flightDate) throws ClassNotFoundException, SQLException;

	boolean updateFlight(Flight flight);

	boolean deleteFlight(Flight flight);

	List<Flight> getAllFlights();
	
	boolean updateSeats(Flight flight) throws ClassNotFoundException, SQLException;
}
