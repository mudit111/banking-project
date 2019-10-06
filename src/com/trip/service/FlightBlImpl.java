package com.trip.service;

import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Flight;
import com.trip.persistance.FlightDao;

public class FlightBlImpl implements FlightBl {

	private FlightDao flightDao;
	
	@Override
	public boolean addFlight(Flight flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Flight> getFlights(String flightOrigin, String flightDestination, LocalDate flightDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateFlight(Flight flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFlight(Flight flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Flight> getAllFlights() {
		// TODO Auto-generated method stub
		return null;
	}

}
