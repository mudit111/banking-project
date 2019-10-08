package com.trip.presentation;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.trip.entity.Flight;
import com.trip.service.FlightBl;
import com.trip.service.FlightBlImpl;
import com.trip.util.FlightHelper;

public class FlightInterfaceImpl implements FlightInterface {

	private FlightBl flightBl;

	public FlightInterfaceImpl() {
		flightBl = new FlightBlImpl();
	}

	@Override
	public void performOnMenu(int choice, String userType) {
		Scanner scanner = new Scanner(System.in);
		Flight flight = new Flight();
		String flightId = null;
		if (userType == "admin") {
			switch (choice) {
			case 1:
				try {
					flightBl.addFlight(FlightHelper.flightInput());
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Enter the Flight ID to update");
				flightId = scanner.next();
				flight.setFlightId(flightId);
				System.out.println("Enter the new Flight Timing");
				LocalTime flightTime = LocalTime.parse(scanner.next());
				flight.setFlightTime(flightTime);
				try {
					flightBl.updateFlight(flight);
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Enter the Flight ID to delete");
				flightId = scanner.next();
				flight.setFlightId(flightId);
				try {
					flightBl.deleteFlight(flight);
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
				break;
			default:
				System.out.println("Please try again with a valid input !!");
			}
		} else if (userType == "user") {
			switch (choice) {
			case 1:
				System.out.println("Enter origin");
				String flightOrigin = scanner.next();
				System.out.println("Enter destination");
				String flightDestination = scanner.next();
				System.out.println("Enter Date (In format YYYY-MM-DD)");
				LocalDate flightDate = LocalDate.parse(scanner.next());
				try {
					List<Flight> flightList = flightBl.getFlights(flightOrigin, flightDestination, flightDate);
					if (!flightList.isEmpty()) {
						for (Flight iterator : flightList)
							System.out.println(iterator);
						System.out.println("Enter Flight Id to book");
						flightId = scanner.next();
						for (Flight iterator : flightList) {
							if (flightId.toUpperCase().equals(iterator.getFlightId().trim().toUpperCase())) {
								if (flightBl.updateSeats(iterator)) {
									System.out.println("The flight is booked successfully");
								} else {
									System.out.println("Sorry No seats Left");
								}
							}
						}
					} else {
						System.out.println("No flights found");
					}
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.getMessage();
				} catch (SQLException sqlException) {
					sqlException.getMessage();
				}
			}
		}
	}
}