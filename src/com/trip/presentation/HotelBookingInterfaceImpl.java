package com.trip.presentation;

import java.sql.SQLException;
import java.util.List;

import com.trip.entity.HotelBooking;
import com.trip.entity.User;
import com.trip.service.HotelBookingBl;
import com.trip.service.HotelBookingBlImpl;

public class HotelBookingInterfaceImpl implements HotelBookingInterface {

	private HotelBookingBl hotelBookingBl;

	public HotelBookingInterfaceImpl() {
		hotelBookingBl = new HotelBookingBlImpl();
	}

	@Override
	public void performOnHotelBookingMenu(User user) {
		try {
			List<HotelBooking> listOfBookedHotels = hotelBookingBl.getBookedHotels(user);
			if (listOfBookedHotels.isEmpty()) {
				System.out.println("No hotels booked by you...");
			} else {
				System.out.println("Hotels booked by you are :");
				System.out.println(listOfBookedHotels);
			}
		} catch (ClassNotFoundException classNotFoundException) {
			classNotFoundException.printStackTrace();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}
