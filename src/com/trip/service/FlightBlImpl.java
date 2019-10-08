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
	public boolean addFlight(Flight flight) throws ClassNotFoundException, SQLException {
		return flightDao.addRecord(flight);
	}

	@Override
	public List<Flight> getFlights(String flightOrigin, String flightDestination, LocalDate flightDate)
			throws ClassNotFoundException, SQLException {
		return flightDao.getRecords(flightOrigin, flightDestination, flightDate);
	}

	@Override
	public boolean updateFlight(Flight flight) throws ClassNotFoundException, SQLException {
		return flightDao.updateRecord(flight);
	}

	@Override
	public boolean deleteFlight(Flight flight) throws ClassNotFoundException, SQLException {
		return flightDao.deleteRecord(flight);
	}

	@Override
	public List<Flight> getAllFlights() throws ClassNotFoundException, SQLException {
		return flightDao.getRecords();
	}

	@Override
	public boolean updateSeats(Flight flight) throws ClassNotFoundException, SQLException {
		return flightDao.updateRecordForSeat(flight);
	}
}