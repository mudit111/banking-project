package com.trip.service;

import java.sql.SQLException;

import com.trip.entity.User;
import com.trip.persistance.UserDao;
import com.trip.persistance.UserDaoImpl;

public class UserBlImpl implements UserBl {

	private UserDao userDao;

	public UserBlImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public boolean addUser(User user) throws ClassNotFoundException, SQLException {
		user.setUserId(user.getUserId());
		user.setUserName(user.getUserName());
		user.setUserAge(user.getUserAge());
		user.setUserType(user.getUserType());
		user.setUserPassword(user.getUserPassword());
		return userDao.addRecord(user);
	}

	@Override
	public User getUser(String userId, String userPassword) throws ClassNotFoundException, SQLException {
		User user = userDao.getRecord(userId, userPassword);
		return user;
	}

}
