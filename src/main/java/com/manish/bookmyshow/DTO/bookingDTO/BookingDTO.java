package com.manish.bookmyshow.DTO.bookingDTO;

import java.time.LocalDateTime;
import java.util.List;

import com.manish.bookmyshow.model.ShowSeat;

public class BookingDTO {
	
	Long showId;
	String movieName;
	String screenName;
	String theatreName;
	String cityName;
	LocalDateTime startTime;
	List<ShowSeat> showSeats;
	public Long getShowId() {
		return showId;
	}
	public void setShowId(Long showId) {
		this.showId = showId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public List<ShowSeat> getShowSeats() {
		return showSeats;
	}
	public void setShowSeats(List<ShowSeat> showSeats) {
		this.showSeats = showSeats;
	}
	public BookingDTO(Long showId, String movieName, String screenName, String theatreName, String cityName,
			LocalDateTime startTime, List<ShowSeat> showSeats) {
		super();
		this.showId = showId;
		this.movieName = movieName;
		this.screenName = screenName;
		this.theatreName = theatreName;
		this.cityName = cityName;
		this.startTime = startTime;
		this.showSeats = showSeats;
	}
	public BookingDTO() {
		super();
	}
	@Override
	public String toString() {
		return "BookingDTO [showId=" + showId + ", movieName=" + movieName + ", screenName=" + screenName
				+ ", theatreName=" + theatreName + ", cityName=" + cityName + ", startTime=" + startTime
				+ ", showSeats=" + showSeats + "]";
	}

	
	
	
}
