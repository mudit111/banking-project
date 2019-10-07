package com.trip.persistance;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Hotel;

public interface HotelDao {

	boolean addRecord(Hotel hotel);

	List<Hotel> getRecords(String hotelLocation, LocalDate hotelDate) throws ClassNotFoundException, SQLException;

	boolean deleteRecord(Hotel hotel);

	List<Hotel> getRecords();

	boolean updateRecordForRoom(Hotel hotel) throws ClassNotFoundException, SQLException;
}
