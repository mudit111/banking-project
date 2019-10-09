package com.trip.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trip.entity.FlightBooking;
import com.trip.entity.User;
import com.trip.service.FlightBookingBl;
import com.trip.service.FlightBookingBlImpl;

public class FlightBookingInterfaceImpl implements FlightBookingInterface {

	private FlightBookingBl flightBookingBl;

	public FlightBookingInterfaceImpl() {
		flightBookingBl = new FlightBookingBlImpl();
	}

	@Override
	public void performOnFlightBookingMenu(User user) {
		try {
			List<FlightBooking> listOfBookedFlights = flightBookingBl.getBookedFlights(user);
			if (listOfBookedFlights.isEmpty()) {
				System.out.println("No flights booked by you..");
			} else {
				System.out.println(listOfBookedFlights);
			}
		} catch (ClassNotFoundException classNotFoundException) {
			classNotFoundException.printStackTrace();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}
