package com.trip.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Hotel;
import com.trip.entity.User;
import com.trip.persistance.HotelDao;
import com.trip.persistance.HotelDaoImpl;

public class HotelBlImpl implements HotelBl {

	private HotelDao hotelDao;

	public HotelBlImpl() {
		hotelDao = new HotelDaoImpl();
	}

	@Override
	public boolean addHotel(Hotel hotel) throws ClassNotFoundException, SQLException {
		return hotelDao.addRecord(hotel);
	}

	@Override
	public List<Hotel> getHotels(String hotelLocation, LocalDate hotelDate)
			throws ClassNotFoundException, SQLException {
		return hotelDao.getRecords(hotelLocation, hotelDate);
	}

	@Override
	public boolean deleteHotels(Hotel hotel) throws ClassNotFoundException, SQLException {
		return hotelDao.deleteRecord(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() throws ClassNotFoundException, SQLException {
		return hotelDao.getRecords();
	}

	@Override
	public boolean updateHotelRooms(Hotel hotel, User user) throws ClassNotFoundException, SQLException {
		return hotelDao.updateRecordForRoom(hotel,user);
	}
}
