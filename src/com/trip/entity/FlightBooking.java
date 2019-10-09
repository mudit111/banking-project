package com.trip.entity;

public class FlightBooking {

	private String flightId;
	private String userId;
	private String bookingId;

	public FlightBooking() {

	}

	public FlightBooking(String flightId, String userId, String bookingId) {
		super();
		this.flightId = flightId;
		this.userId = userId;
		this.bookingId = bookingId;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
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
		return "FlightBooking [flightId=" + flightId + ", userId=" + userId + ", bookingId=" + bookingId + "]";
	}
}
