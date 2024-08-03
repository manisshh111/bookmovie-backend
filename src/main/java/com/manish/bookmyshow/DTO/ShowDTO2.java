package com.manish.bookmyshow.DTO;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

public class ShowDTO2 {
	Long id;
	
	Long movieId;
	
	Long screenId;
	
	LocalDateTime startTime;
	
	Map<Long, Integer> categoryIdToPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Map<Long, Integer> getCategoryIdToPrice() {
		return categoryIdToPrice;
	}

	public void setCategoryIdToPrice(Map<Long, Integer> categoryIdToPrice) {
		this.categoryIdToPrice = categoryIdToPrice;
	}

	public ShowDTO2(Long id, Long movieId, Long screenId, LocalDateTime startTime, Map<Long, Integer> categoryIdToPrice) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.screenId = screenId;
		this.startTime = startTime;
		this.categoryIdToPrice = categoryIdToPrice;
	}

	public ShowDTO2() {
		super();
	}

	@Override
	public String toString() {
		return "ShowDTO [id=" + id + ", movieId=" + movieId + ", screenId=" + screenId + ", startTime=" + startTime
				+ ", categoryIdToPrice=" + categoryIdToPrice + "]";
	}

	

	

	
	
}
