package com.trip.persistance;

import com.trip.entity.User;

public interface UserDao {

	boolean addRecord(User user);

	User getRecord(String userId, String userPassword);
}
