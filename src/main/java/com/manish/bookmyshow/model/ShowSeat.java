package com.manish.bookmyshow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "show_seats")
public class ShowSeat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	
	String seatNumber;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	Category category;
	
	@ManyToOne
	@JoinColumn(name = "show_id")
	Show show;
	
	int price;
	
	@Column(name = "is_booked")
	boolean isBooked;
}
