package com.manish.bookmyshow.service;

import com.manish.bookmyshow.model.Seat;

public interface SeatService {
	
	public Seat createSeat(Seat seat);
	
	public Seat updateSeat(Long id, Seat seat);
	
	public Seat deleteSeat(Long id);
	
	public Seat findSeatByID(Long id);
	
	public Seat findSeatBySeatNumber(String name);

}
