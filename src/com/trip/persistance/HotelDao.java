package com.trip.persistance;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Hotel;
import com.trip.entity.User;

public interface HotelDao {

	boolean addRecord(Hotel hotel) throws ClassNotFoundException, SQLException;

	List<Hotel> getRecords(String hotelLocation, LocalDate hotelDate) throws ClassNotFoundException, SQLException;

	boolean deleteRecord(Hotel hotel) throws SQLException, ClassNotFoundException;

	List<Hotel> getRecords() throws ClassNotFoundException, SQLException;

	boolean updateRecordForRoom(Hotel hotel, User user) throws ClassNotFoundException, SQLException;
}
