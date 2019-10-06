package com.trip.persistance;

import java.time.LocalDate;
import java.util.List;

import com.trip.entity.Hotel;

public interface HotelDao {

	boolean addRecord(Hotel hotel);

	List<Hotel> getRecords(String hotelLocation, LocalDate hotelDate);

	boolean deleteRecord(Hotel hotel);

	List<Hotel> getRecords();
}
