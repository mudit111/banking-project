package com.trip.service;

import java.sql.SQLException;

import com.trip.entity.User;

public interface UserBl {

	boolean addUser(User user) throws ClassNotFoundException, SQLException;

	User getUser(String userId, String userPassword) throws ClassNotFoundException, SQLException;
}
