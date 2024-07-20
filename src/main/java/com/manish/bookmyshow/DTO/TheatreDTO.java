package com.manish.bookmyshow.DTO;

import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

public class TheatreDTO {
	
//	initialFormdata = {
//			  theatreName: "",
//			  cityId: "",
//			  address: "",
//			  screens: [
//			    {
//			      screenName: "",
//			      seats: []
//			    }
//			  ]
//			};
//
	
	
//	

	String theatreName;
	
	@NotNull
	Long cityId;
	String address;
	List<ScreenDTO> screens;
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<ScreenDTO> getScreens() {
		return screens;
	}
	public void setScreens(List<ScreenDTO> screens) {
		this.screens = screens;
	}
	@Override
	public String toString() {
		return "TheatreDTO [theatreName=" + theatreName + ", cityId=" + cityId + ", address=" + address + ", screens="
				+ screens + "]";
	}
	public TheatreDTO(String theatreName, Long cityId, String address, List<ScreenDTO> screens) {
		super();
		this.theatreName = theatreName;
		this.cityId = cityId;
		this.address = address;
		this.screens = screens;
	}
	public TheatreDTO() {
		super();
	}

	
	
	
	

}
