package com.trip.presentation;

import com.trip.service.UserBl;
import com.trip.service.UserBlImpl;

public class UserInterfaceImpl implements UserInterface {

	private UserBl userBl;

	public UserInterfaceImpl() {
		userBl = new UserBlImpl();
	}
	@Override
	public void showMenu() {
		System.out.println("Would you like to ");
		System.out.println("1. Signup?");
		System.out.println("2. Login?");
		System.out.println("3. Exit?");
	}

	@Override
	public void performOnMenu(int choice) {
		switch (choice) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			System.out.println("ThankYou for using our service. Have a great time!");
			System.exit(0);
		default:
			System.out.println("Please try with a valid input....");
		}
	}
}
