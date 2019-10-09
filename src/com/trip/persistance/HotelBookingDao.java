package com.trip.persistance;

import java.sql.SQLException;
import java.util.List;

import com.trip.entity.HotelBooking;
import com.trip.entity.User;

public interface HotelBookingDao {

	List<HotelBooking> getRecords(User user) throws SQLException, ClassNotFoundException;

}
