package com.manish.bookmyshow.DTO;

import java.util.List;
import java.util.Map;

public class ScreenDTO {
	
	String name;
	
	Long theatreId;

	Map<String, List<String>> categoryToSeatNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
	}

	public Map<String, List<String>> getCategoryToSeatNumber() {
		return categoryToSeatNumber;
	}

	public void setCategoryToSeatNumber(Map<String, List<String>> categoryToSeatNumber) {
		this.categoryToSeatNumber = categoryToSeatNumber;
	}

	@Override
	public String toString() {
		return "ScreenDTO [name=" + name + ", theatreId=" + theatreId + ", categoryToSeatNumber=" + categoryToSeatNumber
				+ "]";
	}

	public ScreenDTO(String name, Long theatreId, Map<String, List<String>> categoryToSeatNumber) {
		super();
		this.name = name;
		this.theatreId = theatreId;
		this.categoryToSeatNumber = categoryToSeatNumber;
	}

	public ScreenDTO() {
		super();
	}
	
	
	

}
