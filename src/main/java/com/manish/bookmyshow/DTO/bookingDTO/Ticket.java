package com.manish.bookmyshow.DTO.bookingDTO;

import java.time.LocalDateTime;
import java.util.List;

import com.manish.bookmyshow.model.ShowSeat;

public class Ticket {
	
	Long bookingId;
	String movieName;
	String theatreName;
	String screenName;
	List<ShowSeat> bookedSeats;
	LocalDateTime startTime;
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public List<ShowSeat> getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(List<ShowSeat> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public Ticket(Long bookingId, String movieName, String theatreName, String screenName, List<ShowSeat> bookedSeats,
			LocalDateTime startTime) {
		super();
		this.bookingId = bookingId;
		this.movieName = movieName;
		this.theatreName = theatreName;
		this.screenName = screenName;
		this.bookedSeats = bookedSeats;
		this.startTime = startTime;
	}
	public Ticket() {
		super();
	}
	@Override
	public String toString() {
		return "Ticket [bookingId=" + bookingId + ", movieName=" + movieName + ", theatreName=" + theatreName
				+ ", screenName=" + screenName + ", bookedSeats=" + bookedSeats + ", startTime=" + startTime + "]";
	}
	
	
	
	

}
