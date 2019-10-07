package com.trip.presentation;

import java.sql.SQLException;
import java.util.Scanner;

import com.trip.entity.User;
import com.trip.service.UserBl;
import com.trip.service.UserBlImpl;
import com.trip.util.UserHelper;

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
			boolean status = false;
			User user = UserHelper.userInput();
			try {
				status = userBl.addUser(user);
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			} catch (ClassNotFoundException classNotFoundException) {
				System.out.println(classNotFoundException.getMessage());
			}
			if (status) {
				System.out.println("New User inserted!");
			} else
				System.out.println("There seems to be some problem, please try again.");
			break;
		case 2:
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter you ID and password:");
			String userId = sc.next();
			String userPassword = sc.next();
			try {
				user = userBl.getUser(userId, userPassword);
				while (user != null) {
					if (user.getUserType() == "admin") {
						System.out.println("Admin menu");
						System.out.println("1. Add Flight");
						System.out.println("2. Update Flight");
						System.out.println("3. Delete Flight");
						System.out.println("4. Add Hotel");
						System.out.println("5. Delete Hotel");
						System.out.println("6. Exit");
					} else {
						System.out.println("User menu");
						System.out.println("1. Book Flight");
						System.out.println("2. Book Hotel");
						System.out.println("3. View Itenary");
						System.out.println("4. Exit");
						int userChoice = sc.nextInt();
						switch (userChoice) {
						case 1:
							FlightInterface flightInterface = new FlightInterfaceImpl();
							flightInterface.performOnMenu();
							break;
						case 2:
							HotelInterface hotelInterface = new HotelInterfaceImpl();
							hotelInterface.performOnMenu();
							break;
						case 3:
							break;
						case 4:
							System.out.println("Good bye!!");
							System.exit(0);
						default:
							System.out.println("Please try with a valid input....");
						}
					}
				}
			} catch (ClassNotFoundException classNotFoundException) {
				classNotFoundException.printStackTrace();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
			break;
		case 3:
			System.out.println("ThankYou for using our service. Have a great time!");
			System.exit(0);
		default:
			System.out.println("Please try with a valid input....");
		}
	}
}
