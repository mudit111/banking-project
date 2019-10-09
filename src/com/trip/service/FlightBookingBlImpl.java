package com.trip.service;

import java.sql.SQLException;
import java.util.List;

import com.trip.entity.FlightBooking;
import com.trip.entity.User;
import com.trip.persistance.FlightBookingDao;
import com.trip.persistance.FlightBookingDaoImpl;

public class FlightBookingBlImpl implements FlightBookingBl {

	private FlightBookingDao flightBookingDao;

	public FlightBookingBlImpl() {
		flightBookingDao = new FlightBookingDaoImpl();
	}

	@Override
	public List<FlightBooking> getBookedFlights(User user) throws ClassNotFoundException, SQLException {
		return flightBookingDao.getRecords(user);
	}

}
