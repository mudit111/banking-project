package com.trip.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trip.entity.FlightBooking;
import com.trip.entity.HotelBooking;
import com.trip.entity.User;
import com.trip.util.DbConnection;

public class HotelBookingDaoImpl implements HotelBookingDao {

	@Override
	public List<HotelBooking> getRecords(User user) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DbConnection.getDatabaseConnection();
		List<HotelBooking> hotelBookingList = null;
		preparedStatement = connection.prepareStatement("select * from HotelBooking where userId = ?");
		preparedStatement.setString(1, user.getUserId());
		resultSet = preparedStatement.executeQuery();
		hotelBookingList = new ArrayList<>();
		while (resultSet.next()) {
			HotelBooking hotelBooking = new HotelBooking();
			hotelBooking.setUserId(resultSet.getString("userId"));
			hotelBooking.setHotelId(resultSet.getString("hotelId"));
			hotelBooking.setBookingId(resultSet.getString("bookingId"));
			hotelBookingList.add(hotelBooking);
		}
		connection.close();
		return hotelBookingList;
	}
}
