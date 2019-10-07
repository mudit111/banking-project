package com.trip.persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.trip.entity.Flight;
import com.trip.util.DbConnection;

public class FlightDaoImpl implements FlightDao {

	@Override
	public boolean addRecord(Flight flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Flight> getRecords(String flightOrigin, String flightDestination, LocalDate flightDate)
			throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DbConnection.getDatabaseConnection();
		Date date = Date.valueOf(flightDate);
		List<Flight> flightList = null;
		preparedStatement = connection.prepareStatement(
				"select * from Flight where flightSource = ? and flightDestination = ? and flightDate = ?");
		preparedStatement.setString(1, flightOrigin);
		preparedStatement.setString(2, flightDestination);
		preparedStatement.setDate(3, date);
		resultSet = preparedStatement.executeQuery();
		flightList = new ArrayList<>();
		while (resultSet.next()) {
			Flight flight = new Flight();
			flight.setFlightId(resultSet.getString("flightId"));
			flight.setFlightAirline(resultSet.getString("flightAirline"));
			flight.setFlightSource(resultSet.getString("flightSource"));
			flight.setFlightDestination(resultSet.getString("flightDestination"));
			flight.setFlightTime(resultSet.getTime("flightTime").toLocalTime());
			flight.setFlightDate(resultSet.getDate("flightDate").toLocalDate());
			flight.setFlightPrice(resultSet.getInt("flightPrice"));
			flight.setFlightSeats(resultSet.getInt("flightSeats"));
			flightList.add(flight);
		}
		connection.close();
		return flightList;
	}

	@Override
	public boolean updateRecord(Flight flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRecord(Flight flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Flight> getRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRecordForSeat(Flight flight) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DbConnection.getDatabaseConnection();
		preparedStatement = connection
				.prepareStatement("update Flight set flightSeats = flightSeats-1 where flightId = ? and flightSeats>0");
		preparedStatement.setString(1, flight.getFlightId());
		if (preparedStatement.executeUpdate() == 0) {
			connection.close();
			return false;
		} else {
			connection.close();
			return true;
		}
	}
}