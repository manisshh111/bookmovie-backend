package com.manish.bookmyshow.DTO.selectShowDTO;

import java.util.List;

public class TheatresListDTO {

	String theatreName;
	List<ShowsListDTO> shows;
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public List<ShowsListDTO> getShows() {
		return shows;
	}
	public void setShows(List<ShowsListDTO> shows) {
		this.shows = shows;
	}
	@Override
	public String toString() {
		return "TheatresListDTO [theatreName=" + theatreName + ", shows=" + shows + "]";
	}
	public TheatresListDTO(String theatreName, List<ShowsListDTO> shows) {
		super();
		this.theatreName = theatreName;
		this.shows = shows;
	}
	public TheatresListDTO() {
		super();
	}
	
	
	
}
