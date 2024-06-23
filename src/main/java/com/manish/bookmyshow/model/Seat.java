package com.manish.bookmyshow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "seats")
@Data
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "screen_id")
	Screen screen;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	Category category;
	
	@Column(name = "seat_number")
	String seatNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", screen=" + screen + ", category=" + category + ", seatNumber=" + seatNumber + "]";
	}

	public Seat(Long id, Screen screen, Category category, String seatNumber) {
		super();
		this.id = id;
		this.screen = screen;
		this.category = category;
		this.seatNumber = seatNumber;
	}

	public Seat() {
		super();
	}
	
	
	
	

}
