package com.trip.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trip.entity.FlightBooking;
import com.trip.entity.User;
import com.trip.util.DbConnection;

public class FlightBookingDaoImpl implements FlightBookingDao {

	@Override
	public List<FlightBooking> getRecords(User user) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DbConnection.getDatabaseConnection();
		List<FlightBooking> flightBookingList = null;
		preparedStatement = connection.prepareStatement(
				"select * from FlightBooking where userId = ?");
		preparedStatement.setString(1, user.getUserId());
		resultSet = preparedStatement.executeQuery();
		flightBookingList = new ArrayList<>();
		while (resultSet.next()) {
			FlightBooking flightBooking = new FlightBooking();
			flightBooking.setUserId(resultSet.getString("userId"));
			flightBooking.setFlightId(resultSet.getString("flightId"));
			flightBooking.setBookingId(resultSet.getString("bookingId"));
			flightBookingList.add(flightBooking);
		}
		connection.close();
		return flightBookingList;
	}
}
