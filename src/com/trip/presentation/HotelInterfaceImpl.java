package com.trip.presentation;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.trip.entity.Hotel;
import com.trip.entity.User;
import com.trip.service.HotelBl;
import com.trip.service.HotelBlImpl;
import com.trip.util.FlightHelper;
import com.trip.util.HotelHelper;

public class HotelInterfaceImpl implements HotelInterface {

	private HotelBl hotelBl;

	public HotelInterfaceImpl() {
		hotelBl = new HotelBlImpl();
	}

	@Override
	public void performOnMenu(int choice, User user) {
		if (user.getUserType().trim().equals("admin")) {
			Scanner scanner = new Scanner(System.in);
			Hotel hotel = new Hotel();
			switch (choice) {
			case 1:
				try {
					hotelBl.addHotel(HotelHelper.hotelInput());
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Enter the Hotel ID to delete");
				String hotelId = scanner.next();
				hotel.setHotelId(hotelId);
				try {
					hotelBl.deleteHotels(hotel);
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
				break;
			default:
				System.out.println("Please try again with a valid input !!");
			}
		} else if (user.getUserType().trim().contentEquals("user")) {
			Scanner scanner = new Scanner(System.in);
			switch (choice) {
			case 2:
				System.out.println("Enter location");
				String hotelLocation = scanner.next();
				System.out.println("Enter Date (In format YYYY-MM-DD)");
				LocalDate hotelDate = LocalDate.parse(scanner.next());
				List<Hotel> hotelList;
				try {
					hotelList = hotelBl.getHotels(hotelLocation, hotelDate);
					if (!hotelList.isEmpty()) {
						for (Hotel hotel : hotelList)
							System.out.println(hotel);
						System.out.println("Enter Hotel Id to book");
						String hotelId = scanner.next();
						for (Hotel hotel : hotelList) {
							if (hotelId.toUpperCase().equals(hotel.getHotelId().trim().toUpperCase())) {
								if (hotelBl.updateHotelRooms(hotel,user)) {
									System.out.println("The hotel is booked successfully");
								} else {
									System.out.println("Sorry No rooms Left !!");
								}
							} else {
								System.out.println("No such Id exists");
							}
						}
					} else {
						System.out.println("No hotels found");
					}
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		}
	}
}