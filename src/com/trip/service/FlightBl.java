package com.trip.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Flight;
import com.trip.entity.User;

public interface FlightBl {

	boolean addFlight(Flight flight) throws ClassNotFoundException, SQLException;

	List<Flight> getFlights(String flightOrigin, String flightDestination, LocalDate flightDate)
			throws ClassNotFoundException, SQLException;

	boolean updateFlight(Flight flight) throws ClassNotFoundException, SQLException;

	boolean deleteFlight(Flight flight) throws ClassNotFoundException, SQLException;

	List<Flight> getAllFlights() throws ClassNotFoundException, SQLException;

	boolean updateSeats(Flight flight, User user) throws ClassNotFoundException, SQLException;
}
