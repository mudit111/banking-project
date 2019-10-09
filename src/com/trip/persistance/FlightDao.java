package com.trip.persistance;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Flight;
import com.trip.entity.User;

public interface FlightDao {

	boolean addRecord(Flight flight) throws ClassNotFoundException, SQLException;

	List<Flight> getRecords(String flightOrigin, String flightDestination, LocalDate flightDate) throws SQLException, ClassNotFoundException;

	boolean updateRecord(Flight flight) throws ClassNotFoundException, SQLException;

	boolean deleteRecord(Flight flight) throws ClassNotFoundException, SQLException;

	List<Flight> getRecords() throws SQLException, ClassNotFoundException;
	
	boolean updateRecordForSeat(Flight flight, User user) throws ClassNotFoundException, SQLException;
}
