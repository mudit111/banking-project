package com.trip.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {

	private String flightId;
	private String flightAirline;
	private String flightSource;
	private String flightDestination;
	private LocalTime flightTime;
	private LocalDate flightDate;
	private int flightPrice;
	private int flightSeats;

	public Flight() {

	}

	public Flight(String flightId, String flightAirline, String flightSource, String flightDestination,
			LocalTime flightTime, LocalDate flightDate, int flightPrice, int flightSeats) {
		super();
		this.flightId = flightId;
		this.flightAirline = flightAirline;
		this.flightSource = flightSource;
		this.flightDestination = flightDestination;
		this.flightTime = flightTime;
		this.flightPrice = flightPrice;
		this.flightSeats = flightSeats;
		this.flightDate = flightDate;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightAirline() {
		return flightAirline;
	}

	public void setFlightAirline(String flightAirline) {
		this.flightAirline = flightAirline;
	}

	public String getFlightSource() {
		return flightSource;
	}

	public void setFlightSource(String flightSource) {
		this.flightSource = flightSource;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public String getFlightDestination() {
		return flightDestination;
	}

	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}

	public LocalTime getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(LocalTime flightTime) {
		this.flightTime = flightTime;
	}

	public int getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(int flightPrice) {
		this.flightPrice = flightPrice;
	}

	public int getFlightSeats() {
		return flightSeats;
	}

	public void setFlightSeats(int flightSeats) {
		this.flightSeats = flightSeats;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightAirline=" + flightAirline + ", flightSource=" + flightSource
				+ ", flightDestination=" + flightDestination + ", flightTime=" + flightTime + ", flightDate="
				+ flightDate + ", flightPrice=" + flightPrice + ", flightSeats=" + flightSeats + "]";
	}
}