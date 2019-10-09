package com.trip.service;

import java.sql.SQLException;
import java.util.List;

import com.trip.entity.FlightBooking;
import com.trip.entity.User;

public interface FlightBookingBl {

	List<FlightBooking> getBookedFlights(User user) throws ClassNotFoundException, SQLException;
}
