package com.trip.presentation;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.trip.entity.Flight;
import com.trip.service.FlightBl;
import com.trip.service.FlightBlImpl;

public class FlightInterfaceImpl implements FlightInterface {

	private FlightBl flightBl;

	public FlightInterfaceImpl() {
		flightBl = new FlightBlImpl();
	}

	@Override
	public void performOnMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter origin");
		String flightOrigin = scanner.next();
		System.out.println("Enter destination");
		String flightDestination = scanner.next();
		System.out.println("Enter Date (In format YYYY-MM-DD)");
		LocalDate flightDate = LocalDate.parse(scanner.next());
		try {
			List<Flight> flightList = flightBl.getFlights(flightOrigin, flightDestination, flightDate);
			if (!flightList.isEmpty()) {
				for (Flight flight : flightList)
					System.out.println(flight);
				System.out.println("Enter Flight Id to book");
				String flightId = scanner.next();
				for (Flight flight : flightList) {
					if (flightId.toUpperCase().equals(flight.getFlightId().trim().toUpperCase())) {
						if (flightBl.updateSeats(flight)) {
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