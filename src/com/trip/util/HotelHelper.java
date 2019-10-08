package com.trip.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.trip.entity.Flight;
import com.trip.entity.Hotel;

public class HotelHelper {
	public static Hotel hotelInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Hotel ID:");
		String hotelId = scanner.next();
		System.out.println("Enter Hotel Name:");
		String hotelName = scanner.next();
		System.out.println("Enter Hotel Location:");
		String hotelLocation = scanner.next();
		System.out.println("Enter Hotel Price:");
		int hotelPrice = scanner.nextInt();
		System.out.println("Enter Number of rooms in the Hotel:");
		int hotelNoOfRooms = scanner.nextInt();
		System.out.println("Enter Hotel Date:");
		LocalDate hotelDate = LocalDate.parse(scanner.next());
		Hotel hotel = new Hotel(hotelId, hotelName, hotelLocation, hotelPrice, hotelNoOfRooms, hotelDate);
		return hotel;
	}
}
