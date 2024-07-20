package com.manish.bookmyshow.DTO;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ScreenDTO {
	
//	  screenName: '',
//	  seats: []
	
	String screenName;
	
	
	List<SeatDTO> seats;
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public List<SeatDTO> getSeats() {
		return seats;
	}
	public void setSeats(List<SeatDTO> seats) {
		this.seats = seats;
	}
	public ScreenDTO(String screenName, List<SeatDTO> seats) {
		super();
		this.screenName = screenName;
		this.seats = seats;
	}
	public ScreenDTO() {
		super();
	}
	@Override
	public String toString() {
		return "ScreenDTO [screenName=" + screenName + ", seats=" + seats + "]";
	}
	
	
	
	
	

}
