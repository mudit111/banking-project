package com.trip.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trip.entity.User;
import com.trip.util.DbConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean addRecord(User user) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DbConnection.getDatabaseConnection();
		preparedStatement = connection.prepareStatement("insert into Users values(?,?,?,?,?)");

		preparedStatement.setString(1, user.getUserId());
		preparedStatement.setString(2, user.getUserName());
		preparedStatement.setInt(3, user.getUserAge());
		preparedStatement.setString(4, user.getUserType());
		preparedStatement.setString(5, user.getUserPassword());

		int status = preparedStatement.executeUpdate();
		connection.close();

		if (status > 0) {
			return true;
		}
		return false;
	}

	@Override
	public User getRecord(String userId, String userPassword) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DbConnection.getDatabaseConnection();
		preparedStatement = connection.prepareStatement("select * from Users where userId = ? and userPassword = ?");
		preparedStatement.setString(1, userId);
		preparedStatement.setString(2, userPassword);
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			User user = new User();
			user.setUserId(resultSet.getString("userId"));
			user.setUserType(resultSet.getString("userType"));
			connection.close();
			return user;
		}
		return null;
	}
}
