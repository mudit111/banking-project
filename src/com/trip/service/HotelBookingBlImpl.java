package com.trip.service;

import java.sql.SQLException;
import java.util.List;

import com.trip.entity.HotelBooking;
import com.trip.entity.User;
import com.trip.persistance.HotelBookingDao;
import com.trip.persistance.HotelBookingDaoImpl;

public class HotelBookingBlImpl implements HotelBookingBl {

	private HotelBookingDao hotelBookingDao;

	public HotelBookingBlImpl() {
		hotelBookingDao = new HotelBookingDaoImpl();
	}

	@Override
	public List<HotelBooking> getBookedHotels(User user) throws ClassNotFoundException, SQLException {
		return hotelBookingDao.getRecords(user);
	}
}