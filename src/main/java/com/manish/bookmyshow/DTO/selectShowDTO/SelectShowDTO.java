package com.manish.bookmyshow.DTO.selectShowDTO;

import java.util.List;

public class SelectShowDTO {

	String movieName;
	String cityName;
	
	List<TheatresListDTO> theatres;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<TheatresListDTO> getTheatres() {
		return theatres;
	}

	public void setTheatres(List<TheatresListDTO> theatres) {
		this.theatres = theatres;
	}

	@Override
	public String toString() {
		return "SelectShowDTO [movieName=" + movieName + ", cityName=" + cityName + ", theatres=" + theatres + "]";
	}

	public SelectShowDTO(String movieName, String cityName, List<TheatresListDTO> theatres) {
		super();
		this.movieName = movieName;
		this.cityName = cityName;
		this.theatres = theatres;
	}

	public SelectShowDTO() {
		super();
	}
	
	
	
	
	
	
}
