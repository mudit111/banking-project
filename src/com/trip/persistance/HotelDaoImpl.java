package com.trip.persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.trip.entity.Hotel;
import com.trip.util.DbConnection;

public class HotelDaoImpl implements HotelDao {

	@Override
	public boolean addRecord(Hotel hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Hotel> getRecords(String hotelLocation, LocalDate hotelDate)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DbConnection.getDatabaseConnection();
		Date date = Date.valueOf(hotelDate);
		List<Hotel> hotelList = null;
		preparedStatement = connection
				.prepareStatement("select * from Hotel where hotelLocation = ? and hotelDate = ?");
		preparedStatement.setString(1, hotelLocation);
		preparedStatement.setDate(2, date);
		resultSet = preparedStatement.executeQuery();
		hotelList = new ArrayList<>();
		while (resultSet.next()) {
			Hotel hotel = new Hotel();
			hotel.setHotelId(resultSet.getString("hotelId"));
			hotel.setHotelName(resultSet.getString("hotelName"));
			hotel.setHotelLocation(resultSet.getString("hotelLocation"));
			hotel.setHotelPrice(resultSet.getInt("hotelPrice"));
			hotel.setHotelNoOfRooms(resultSet.getInt("hotelNoOfRooms"));
			hotel.setHotelDate(resultSet.getDate("hotelDate").toLocalDate());
			hotelList.add(hotel);
		}
		connection.close();
		return hotelList;
	}

	@Override
	public boolean deleteRecord(Hotel hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Hotel> getRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRecordForRoom(Hotel hotel) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DbConnection.getDatabaseConnection();
		preparedStatement = connection.prepareStatement(
				"update Hotel set hotelNoOfRooms = hotelNoOfRooms-1 where hotelId = ? and hotelNoOfRooms>0");
		preparedStatement.setString(1, hotel.getHotelId());
		if (preparedStatement.executeUpdate() == 0) {
			connection.close();
			return false;
		} else {
			connection.close();
			return true;
		}
	}
}
