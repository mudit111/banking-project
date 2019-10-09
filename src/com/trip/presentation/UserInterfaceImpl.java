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
	public void showMainMenu() {
		System.out.println("Would you like to ");
		System.out.println("1. Signup?");
		System.out.println("2. Login?");
		System.out.println("3. Exit?");
	}

	@Override
	public void showAdminMenu() {
		System.out.println("Admin menu");
		System.out.println("1. Add Flight");
		System.out.println("2. Update Flight");
		System.out.println("3. Delete Flight");
		System.out.println("4. Add Hotel");
		System.out.println("5. Delete Hotel");
		System.out.println("6. Exit");
	}

	@Override
	public void performOnAdminMenu(int choice, User user) {
		switch (choice) {
		case 1:
		case 2:
		case 3:
			FlightInterface flightInterface = new FlightInterfaceImpl();
			flightInterface.performOnMenu(choice, user);
			break;
		case 4:
		case 5:
			HotelInterface hotelInterface = new HotelInterfaceImpl();
			hotelInterface.performOnMenu(choice - 3, user);
			break;
		case 6:
			System.out.println("Good Bye !!");
			System.exit(0);
			break;
		default:
			System.out.println("Please try again with a valid input !!");
		}
	}

	@Override
	public void performOnUserMenu(int choice, User user) {
		switch (choice) {
		case 1:
			FlightInterface flightInterface = new FlightInterfaceImpl();
			flightInterface.performOnMenu(choice, user);
			break;
		case 2:
			HotelInterface hotelInterface = new HotelInterfaceImpl();
			hotelInterface.performOnMenu(choice, user);
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			boolean userChoice = true;
			while (userChoice) {
				System.out.println("1. View Itenary of Flight");
				System.out.println("2. View Itenary of Hotel");
				System.out.println("3. Go back");
				Scanner scanner = new Scanner(System.in);
				switch (scanner.nextInt()) {
				case 1:
					FlightBookingInterface flightBookingInterface = new FlightBookingInterfaceImpl();
					flightBookingInterface.performOnFlightBookingMenu(user);
					break;
				case 2:
					HotelBookingInterface hotelBookingInterface = new HotelBookingInterfaceImpl();
					hotelBookingInterface.performOnHotelBookingMenu(user);
					break;
				case 3:
					userChoice = false;
					break;
				default:
					System.out.println("Please try again with a valid input");
				}
			}
			break;
		case 6:
			System.out.println("Good bye!!");
			System.exit(0);
		default:
			System.out.println("Please try with a valid input....");
		}
	}

	@Override
	public void showUserMenu() {
		System.out.println("User menu");
		System.out.println("1. Book Flight");
		System.out.println("2. Book Hotel");
		System.out.println("3. Cancel Flight");
		System.out.println("4. Cancel Hotel");
		System.out.println("5. View Itenary");
		System.out.println("6. Exit");
	}

	@Override
	public void performOnMainMenu(int choice) {
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
				System.out.println("SignUp Successful");
			} else
				System.out.println("There seems to be some problem, please try again !!");
			break;
		case 2:
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter you ID and password:");
			String userId = sc.next();
			String userPassword = sc.next();
			try {
				user = userBl.getUser(userId, userPassword);
				while (user != null) {
					if (user.getUserType().trim().equals("admin")) {
						showAdminMenu();
						int userChoice = sc.nextInt();
						performOnAdminMenu(userChoice, user);
					} else {
						showUserMenu();
						int userChoice = sc.nextInt();
						performOnUserMenu(userChoice, user);
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