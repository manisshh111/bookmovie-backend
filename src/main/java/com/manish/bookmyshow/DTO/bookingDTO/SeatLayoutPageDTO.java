package com.manish.bookmyshow.DTO.bookingDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.manish.bookmyshow.model.ShowSeat;

public class SeatLayoutPageDTO {
	
	Long showId;
	String movieName;
	String screenName;
	String theatreName;
	String cityName;
	LocalDateTime startTime;
	List<CategSeatDTO> categSeatsList;
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
	public List<CategSeatDTO> getCategSeatsList() {
		return categSeatsList;
	}
	public void setCategSeatsList(List<CategSeatDTO> categSeatsList) {
		this.categSeatsList = categSeatsList;
	}
	public SeatLayoutPageDTO(Long showId, String movieName, String screenName, String theatreName, String cityName,
			LocalDateTime startTime, List<CategSeatDTO> categSeatsList) {
		super();
		this.showId = showId;
		this.movieName = movieName;
		this.screenName = screenName;
		this.theatreName = theatreName;
		this.cityName = cityName;
		this.startTime = startTime;
		this.categSeatsList = categSeatsList;
	}
	public SeatLayoutPageDTO() {
		super();
	}
	@Override
	public String toString() {
		return "SeatLayoutPageDTO [showId=" + showId + ", movieName=" + movieName + ", screenName=" + screenName
				+ ", theatreName=" + theatreName + ", cityName=" + cityName + ", startTime=" + startTime
				+ ", categSeatsList=" + categSeatsList + "]";
	}
	
	
	
	
	
	
	

}
