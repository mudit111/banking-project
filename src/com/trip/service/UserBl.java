package com.trip.service;

import com.trip.entity.User;

public interface UserBl {

	boolean addUser(User user);

	User getUser(String userId, String userPassword);
}
