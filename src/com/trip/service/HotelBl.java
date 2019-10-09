package com.trip.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Hotel;
import com.trip.entity.User;

public interface HotelBl {

	boolean addHotel(Hotel hotel) throws ClassNotFoundException, SQLException;

	List<Hotel> getHotels(String hotelLocation, LocalDate hotelDate) throws ClassNotFoundException, SQLException;

	boolean deleteHotels(Hotel hotel) throws ClassNotFoundException, SQLException;

	List<Hotel> getAllHotels() throws ClassNotFoundException, SQLException;

	boolean updateHotelRooms(Hotel hotel,User user) throws ClassNotFoundException, SQLException;
}
