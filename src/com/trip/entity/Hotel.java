package com.trip.entity;

import java.time.LocalDate;

public class Hotel {

	private String hotelId;
	private String hotelName;
	private String hotelLocation;
	private int hotelPrice;
	private int hotelNoOfRooms;
	private LocalDate hotelDate;

	public Hotel() {

	}

	public Hotel(String hotelId, String hotelName, int hotelPrice, String hotelLocation, int hotelNoOfRooms,
			LocalDate hotelDate) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelPrice = hotelPrice;
		this.hotelLocation = hotelLocation;
		this.hotelNoOfRooms = hotelNoOfRooms;
		this.hotelDate = hotelDate;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getHotelPrice() {
		return hotelPrice;
	}

	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}

	public String getHotelLocation() {
		return hotelLocation;
	}

	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}

	public int getHotelNoOfRooms() {
		return hotelNoOfRooms;
	}

	public void setHotelNoOfRooms(int hotelNoOfRooms) {
		this.hotelNoOfRooms = hotelNoOfRooms;
	}

	public LocalDate getHotelDate() {
		return hotelDate;
	}

	public void setHotelDate(LocalDate hotelDate) {
		this.hotelDate = hotelDate;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelPrice=" + hotelPrice
				+ ", hotelLocation=" + hotelLocation + ", hotelNoOfRooms=" + hotelNoOfRooms + ", hotelDate=" + hotelDate
				+ "]";
	}

}
