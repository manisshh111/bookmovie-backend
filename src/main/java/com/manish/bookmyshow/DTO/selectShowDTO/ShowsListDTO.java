package com.manish.bookmyshow.DTO.selectShowDTO;

import java.time.LocalDateTime;

public class ShowsListDTO {

	Long showId;
	LocalDateTime startTime;
	
	public ShowsListDTO(Long showId, LocalDateTime startTime) {
		super();
		this.showId = showId;
		this.startTime = startTime;
	}
	
	
	public ShowsListDTO() {
		super();
	}


	public Long getShowId() {
		return showId;
	}
	public void setShowId(Long showId) {
		this.showId = showId;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	@Override
	public String toString() {
		return "ShowsListDTO [showId=" + showId + ", startTime=" + startTime + "]";
	}
	
	
}
