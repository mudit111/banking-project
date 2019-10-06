package com.trip.persistance;

import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Flight;

public class FlightDaoImpl implements FlightDao {

	@Override
	public boolean addRecord(Flight flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Flight> getRecords(String flightOrigin, String flightDestination, LocalDate flightDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRecord(Flight flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRecord(Flight flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Flight> getRecords() {
		// TODO Auto-generated method stub
		return null;
	}

}