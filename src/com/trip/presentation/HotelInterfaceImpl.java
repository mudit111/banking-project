package com.trip.presentation;

import com.trip.service.HotelBl;
import com.trip.service.HotelBlImpl;

public class HotelInterfaceImpl implements HotelInterface {

	private HotelBl hotelBl;
	
	public HotelInterfaceImpl() {
		hotelBl = new HotelBlImpl();
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
