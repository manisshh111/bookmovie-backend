package com.manish.bookmyshow.DTO.AddShow;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class ShowDTO {

	Long movieId;
	Long screenId;
	LocalDateTime startTime;
	List<CategPriceDTO> categPrice;
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public Long getScreenId() {
		return screenId;
	}
	public void setScreenId(Long screenId) {
		this.screenId = screenId;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public List<CategPriceDTO> getCategPrice() {
		return categPrice;
	}
	public void setCategPrice(List<CategPriceDTO> categPrice) {
		this.categPrice = categPrice;
	}
	public ShowDTO(Long movieId, Long screenId, LocalDateTime startTime, List<CategPriceDTO> categPrice) {
		super();
		this.movieId = movieId;
		this.screenId = screenId;
		this.startTime = startTime;
		this.categPrice = categPrice;
	}
	
	
	public ShowDTO() {
		super();
	}
	@Override
	public String toString() {
		return "ShowDTO [movieId=" + movieId + ", screenId=" + screenId + ", startTime=" + startTime + ", categPrice="
				+ categPrice + "]";
	}
	

	
	
	
	
	
}
