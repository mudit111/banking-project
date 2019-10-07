package com.trip.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Flight;
import com.trip.persistance.FlightDao;
import com.trip.persistance.FlightDaoImpl;

public class FlightBlImpl implements FlightBl {

	private FlightDao flightDao;

	public FlightBlImpl() {
		flightDao = new FlightDaoImpl();
	}

	@Override
	public boolean addFlight(Flight flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Flight> getFlights(String flightOrigin, String flightDestination, LocalDate flightDate)
			throws ClassNotFoundException, SQLException {
		List<Flight> flightsList = flightDao.getRecords(flightOrigin, flightDestination, flightDate);
		return flightsList;
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

	@Override
	public boolean updateSeats(Flight flight) throws ClassNotFoundException, SQLException {
		boolean seatStatus = flightDao.updateRecordForSeat(flight); 
		return seatStatus;
	}

}
