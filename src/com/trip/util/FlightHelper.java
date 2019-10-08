package com.trip.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.trip.entity.Flight;

public class FlightHelper {
	public static Flight flightInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Flight ID:");
		String flightId = scanner.next();
		System.out.println("Enter Flight Airline:");
		String flightAirline = scanner.next();
		System.out.println("Enter Flight Source:");
		String flightSource = scanner.next();
		System.out.println("Enter Flight Destination:");
		String flightDestination = scanner.next();
		System.out.println("Enter Flight Time:");
		LocalTime flightTime = LocalTime.parse(scanner.next());
		System.out.println("Enter Flight Date:");
		LocalDate flightDate = LocalDate.parse(scanner.next());
		System.out.println("Enter Flight Price:");
		int flightPrice = scanner.nextInt();
		System.out.println("Enter Number of Seats in Flight:");
		int flightSeats = scanner.nextInt();
		Flight flight = new Flight(flightId, flightAirline, flightSource, flightDestination, flightTime, flightDate,
				flightPrice, flightSeats);
		return flight;
	}
}
