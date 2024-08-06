package com.manish.bookmyshow.DTO.bookingDTO;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manish.bookmyshow.model.ShowSeat;

public class SlSeatDTO {

	Character row;
	List<ShowSeat> showSeats;
	public Character getRow() {
		return row;
	}
	public void setRow(Character row) {
		this.row = row;
	}
	public List<ShowSeat> getShowSeats() {
		return showSeats;
	}
	public void setShowSeats(List<ShowSeat> showSeats) {
		this.showSeats = showSeats;
	}
	public SlSeatDTO(Character row, List<ShowSeat> showSeats) {
		super();
		this.row = row;
		this.showSeats = showSeats;
	}
	public SlSeatDTO() {
		super();
	}
	@Override
	public String toString() {
		return "SlSeatDTO [row=" + row + ", showSeats=" + showSeats + "]";
	}
	
	
	

}
