package com.trip.persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.trip.entity.Flight;
import com.trip.entity.User;
import com.trip.util.DbConnection;
import java.util.Random;

public class FlightDaoImpl implements FlightDao {

	@Override
	public boolean addRecord(Flight flight) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DbConnection.getDatabaseConnection();
		preparedStatement = connection.prepareStatement("insert into Flight values(?,?,?,?,?,?,?,?)");
		preparedStatement.setString(1, flight.getFlightId());
		preparedStatement.setString(2, flight.getFlightAirline());
		preparedStatement.setString(3, flight.getFlightSource());
		preparedStatement.setString(4, flight.getFlightDestination());
		preparedStatement.setTime(5, Time.valueOf(flight.getFlightTime()));
		preparedStatement.setDate(6, Date.valueOf(flight.getFlightDate()));
		preparedStatement.setInt(7, flight.getFlightPrice());
		preparedStatement.setInt(8, flight.getFlightSeats());
		boolean status = preparedStatement.execute();
		connection.close();
		return status;
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
	public boolean updateRecord(Flight flight) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DbConnection.getDatabaseConnection();
		preparedStatement = connection.prepareStatement("update flight set flightTime=? where flightId=?");
		preparedStatement.setTime(1, Time.valueOf(flight.getFlightTime()));
		preparedStatement.setString(2, flight.getFlightId());
		boolean status = preparedStatement.execute();
		connection.close();
		return status;

	}

	@Override
	public boolean deleteRecord(Flight flight) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DbConnection.getDatabaseConnection();
		preparedStatement = connection.prepareStatement("delete from flight where flightId=?");
		preparedStatement.setString(1, flight.getFlightId());
		boolean status = preparedStatement.execute();
		connection.close();
		return status;
	}

	@Override
	public List<Flight> getRecords() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DbConnection.getDatabaseConnection();
		List<Flight> flightList = null;
		preparedStatement = connection.prepareStatement("select * from Flight");
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
	public boolean updateRecordForSeat(Flight flight, User user) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DbConnection.getDatabaseConnection();
		preparedStatement = connection
				.prepareStatement("update Flight set flightSeats = flightSeats-? where flightId = ? and flightSeats>0");
		preparedStatement.setInt(1, 1);
		preparedStatement.setString(2, flight.getFlightId());
		if (preparedStatement.executeUpdate() == 0) {
			connection.close();
			return false;
		} else {
			Random random = new Random();
			preparedStatement = connection.prepareStatement("insert into FlightBooking values (?,?,?)");
			preparedStatement.setString(1, user.getUserId());
			preparedStatement.setString(2, flight.getFlightId());
			preparedStatement.setString(3, String.valueOf(random.nextInt(10000)));
			int status = preparedStatement.executeUpdate();
			connection.close();
			if (status == 0)
				return false;
			return true;
		}
	}
}