package com.trip.persistance;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Flight;

public interface FlightDao {

	boolean addRecord(Flight flight);

	List<Flight> getRecords(String flightOrigin, String flightDestination, LocalDate flightDate) throws SQLException, ClassNotFoundException;

	boolean updateRecord(Flight flight);

	boolean deleteRecord(Flight flight);

	List<Flight> getRecords();
	
	boolean updateRecordForSeat(Flight flight) throws ClassNotFoundException, SQLException;
}
