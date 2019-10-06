package com.trip.persistance;

import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Flight;

public interface FlightDao {

	boolean addRecord(Flight flight);

	List<Flight> getRecords(String flightOrigin, String flightDestination, LocalDate flightDate);

	boolean updateRecord(Flight flight);

	boolean deleteRecord(Flight flight);

	List<Flight> getRecords();
}
