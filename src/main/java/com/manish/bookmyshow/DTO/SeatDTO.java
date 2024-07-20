package com.manish.bookmyshow.DTO;

import org.antlr.v4.runtime.misc.NotNull;

public class SeatDTO {

	Long categoryId;
	char fromRow;
	int fromSeat;
	char toRow;
	int toSeat;
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public char getFromRow() {
		return fromRow;
	}
	public void setFromRow(char fromRow) {
		this.fromRow = fromRow;
	}
	public int getFromSeat() {
		return fromSeat;
	}
	public void setFromSeat(int fromSeat) {
		this.fromSeat = fromSeat;
	}
	public char getToRow() {
		return toRow;
	}
	public void setToRow(char toRow) {
		this.toRow = toRow;
	}
	public int getToSeat() {
		return toSeat;
	}
	public void setToSeat(int toSeat) {
		this.toSeat = toSeat;
	}
	@Override
	public String toString() {
		return "SeatDTO [categoryId=" + categoryId + ", fromRow=" + fromRow + ", fromSeat=" + fromSeat + ", toRow="
				+ toRow + ", toSeat=" + toSeat + "]";
	}
	public SeatDTO(Long categoryId, char fromRow, int fromSeat, char toRow, int toSeat) {
		super();
		this.categoryId = categoryId;
		this.fromRow = fromRow;
		this.fromSeat = fromSeat;
		this.toRow = toRow;
		this.toSeat = toSeat;
	}
	public SeatDTO() {
		super();
	}
	
	
	
}
