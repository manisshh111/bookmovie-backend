package com.manish.bookmyshow.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.sym.Name;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "shows")
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "movie_id")
	Movie movie;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "screen_id")
	Screen screen;
	
	@Column(name = "start_time", nullable = false)
	Date startTime;
	
	@OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
	List<ShowSeat> seatForShows;
	
	@OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
	List<Booking> bookings;
	
}
