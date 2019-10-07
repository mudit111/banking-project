package com.trip.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Hotel;
import com.trip.persistance.HotelDao;
import com.trip.persistance.HotelDaoImpl;

public class HotelBlImpl implements HotelBl {

	private HotelDao hotelDao;

	public HotelBlImpl() {
		hotelDao = new HotelDaoImpl();
	}

	@Override
	public boolean addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Hotel> getHotels(String hotelLocation, LocalDate hotelDate)
			throws ClassNotFoundException, SQLException {
		List<Hotel> hotelList = hotelDao.getRecords(hotelLocation, hotelDate);
		return hotelList;
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

	@Override
	public boolean updateHotelRooms(Hotel hotel) throws ClassNotFoundException, SQLException {
		boolean roomStatus = hotelDao.updateRecordForRoom(hotel);
		return roomStatus;
	}

}
