package com.trip.entity;

public class HotelBooking {

	private String hotelId;
	private String userId;
	private String bookingId;

	public HotelBooking() {

	}

	public HotelBooking(String hotelId, String userId, String bookingId) {
		super();
		this.hotelId = hotelId;
		this.userId = userId;
		this.bookingId = bookingId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "HotelBooking [hotelId=" + hotelId + ", userId=" + userId + ", bookingId=" + bookingId + "]";
	}
}
