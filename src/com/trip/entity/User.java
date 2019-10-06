package com.trip.entity;

public class User {

	private String userName;
	private String userId;
	private int userAge;
	private String userType;
	private String userPassword;

	public User(String userName, String userId, int userAge, String userType, String userPassword) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userAge = userAge;
		this.userType = userType;
		this.userPassword = userPassword;
	}

	public User() {

	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserId() {
		return userId;
	}

	public int getUserAge() {
		return userAge;
	}

	public String getUserType() {
		return userType;
	}

	public String getUserPassword() {
		return userPassword;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId + ", userAge=" + userAge + ", userType=" + userType
				+ ", userPassword=" + userPassword + "]";
	}

}
