package com.trip.persistance;

import java.sql.SQLException;

import com.trip.entity.User;

public interface UserDao {

	boolean addRecord(User user) throws ClassNotFoundException, SQLException;

	User getRecord(String userId, String userPassword) throws SQLException, ClassNotFoundException;
}
