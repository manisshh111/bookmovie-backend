package com.manish.bookmyshow.DTO;

import java.util.Date;
import java.util.Map;

public class ShowDTO {
	Long id;
	
	Long movieId;
	
	Long screenId;
	
	Date startTime;
	
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Map<Long, Integer> getCategoryIdToPrice() {
		return categoryIdToPrice;
	}

	public void setCategoryIdToPrice(Map<Long, Integer> categoryIdToPrice) {
		this.categoryIdToPrice = categoryIdToPrice;
	}

	public ShowDTO(Long id, Long movieId, Long screenId, Date startTime, Map<Long, Integer> categoryIdToPrice) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.screenId = screenId;
		this.startTime = startTime;
		this.categoryIdToPrice = categoryIdToPrice;
	}

	public ShowDTO() {
		super();
	}

	@Override
	public String toString() {
		return "ShowDTO [id=" + id + ", movieId=" + movieId + ", screenId=" + screenId + ", startTime=" + startTime
				+ ", categoryIdToPrice=" + categoryIdToPrice + "]";
	}

	

	

	
	
}
