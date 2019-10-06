package com.trip.presentation;

import com.trip.service.FlightBl;
import com.trip.service.FlightBlImpl;

public class FlightInterfaceImpl implements FlightInterface {

	private FlightBl flightBl;
	
	public FlightInterfaceImpl() {
		flightBl = new FlightBlImpl();
	}
	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
	}

	@Override
	public void performOnMenu(int choice) {
		// TODO Auto-generated method stub

	}
}
