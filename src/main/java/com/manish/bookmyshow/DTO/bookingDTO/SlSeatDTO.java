package com.manish.bookmyshow.DTO.bookingDTO;

import java.util.List;
import java.util.Map;

import com.manish.bookmyshow.model.ShowSeat;

public class SlSeatDTO {

	Map<Character, List<ShowSeat>> rowVsSeatsMap;
	

	public Map<Character, List<ShowSeat>> getRowVsSeatsList() {
		return rowVsSeatsMap;
	}

	public void setRowVsSeatsList(Map<Character, List<ShowSeat>> rowVsSeatsList) {
		this.rowVsSeatsMap = rowVsSeatsList;
	}

	public SlSeatDTO(Map<Character, List<ShowSeat>> rowVsSeatsList) {
		super();
		this.rowVsSeatsMap = rowVsSeatsList;
	}

	@Override
	public String toString() {
		return "SlSeatDTO [rowVsSeatsMap=" + rowVsSeatsMap + "]";
	}

	public SlSeatDTO() {
		super();
	}
	
	

}
