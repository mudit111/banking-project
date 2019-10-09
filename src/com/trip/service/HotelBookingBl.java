package com.trip.service;

import java.sql.SQLException;
import java.util.List;

import com.trip.entity.HotelBooking;
import com.trip.entity.User;

public interface HotelBookingBl {

	public List<HotelBooking> getBookedHotels(User user) throws ClassNotFoundException, SQLException;

}
