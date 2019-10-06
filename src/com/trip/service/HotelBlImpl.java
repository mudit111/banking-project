package com.trip.service;

import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Hotel;
import com.trip.persistance.FlightDao;
import com.trip.persistance.HotelDao;

public class HotelBlImpl implements HotelBl {

	private HotelDao hoteDao;	
	
	@Override
	public boolean addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Hotel> getHotels(String hotelLocation, LocalDate hotelDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteHotels(Hotel hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return null;
	}

}
