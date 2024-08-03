package com.manish.bookmyshow.DTO.AddShow;

import java.util.List;

public class CreateShowDTO {

	Long cityId;
	long theatreId;
	List<ShowDTO> shows;
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public long getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(long theatreId) {
		this.theatreId = theatreId;
	}
	public List<ShowDTO> getShows() {
		return shows;
	}
	public void setShows(List<ShowDTO> shows) {
		this.shows = shows;
	}
	public CreateShowDTO(Long cityId, long theatreId, List<ShowDTO> shows) {
		super();
		this.cityId = cityId;
		this.theatreId = theatreId;
		this.shows = shows;
	}
	public CreateShowDTO() {
		super();
	}
	@Override
	public String toString() {
		return "CreateShowDTO [cityId=" + cityId + ", theatreId=" + theatreId + ", shows=" + shows + "]";
	}
	
	
}
