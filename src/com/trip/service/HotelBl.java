package com.trip.service;

import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Hotel;

public interface HotelBl {
	boolean addHotel(Hotel hotel);

	List<Hotel> getHotels(String hotelLocation, LocalDate hotelDate);

	boolean deleteHotels(Hotel hotel);

	List<Hotel> getAllHotels();
}
