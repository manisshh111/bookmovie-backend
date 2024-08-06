package com.manish.bookmyshow.DTO.bookingDTO;

import java.util.List;

public class CategSeatDTO {

	SlCategoryDTO categPrice;
	List<SlSeatDTO> rowVsSeats;

	public SlCategoryDTO getCategPrice() {
		return categPrice;
	}

	public void setCategPrice(SlCategoryDTO categPrice) {
		this.categPrice = categPrice;
	}

	public List<SlSeatDTO> getRowVsSeats() {
		return rowVsSeats;
	}

	public void setRowVsSeats(List<SlSeatDTO> rowVsSeats) {
		this.rowVsSeats = rowVsSeats;
	}

	@Override
	public String toString() {
		return "CategSeatDTO [categPrice=" + categPrice + ", rowVsSeats=" + rowVsSeats + "]";
	}

	public CategSeatDTO(SlCategoryDTO categPrice, List<SlSeatDTO> rowVsSeats) {
		super();
		this.categPrice = categPrice;
		this.rowVsSeats = rowVsSeats;
	}

	public CategSeatDTO() {
		super();
	}

}
