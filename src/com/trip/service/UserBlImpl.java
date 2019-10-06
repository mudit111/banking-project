package com.trip.service;

import com.trip.entity.User;
import com.trip.persistance.UserDao;
import com.trip.persistance.UserDaoImpl;

public class UserBlImpl implements UserBl {

private UserDao userDao;
	
	public UserBlImpl(){
		userDao=new UserDaoImpl();
	}
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(String userId, String userPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
