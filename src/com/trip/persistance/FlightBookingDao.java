package com.trip.persistance;

import java.sql.SQLException;
import java.util.List;

import com.trip.entity.FlightBooking;
import com.trip.entity.User;

public interface FlightBookingDao {

	List<FlightBooking> getRecords(User user) throws SQLException, ClassNotFoundException;

}
