package com.manish.bookmyshow.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.Data;

@Entity
@Table(name = "shows")
@Data
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
	LocalDateTime startTime;
	
	@JsonIgnore
	@OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
	List<ShowSeat> seatForShows;
	
	@JsonIgnore
	@OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
	List<Booking> bookings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public List<ShowSeat> getSeatForShows() {
		return seatForShows;
	}

	public void setSeatForShows(List<ShowSeat> seatForShows) {
		this.seatForShows = seatForShows;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Show(Long id, Movie movie, Screen screen, LocalDateTime startTime, List<ShowSeat> seatForShows,
			List<Booking> bookings) {
		super();
		this.id = id;
		this.movie = movie;
		this.screen = screen;
		this.startTime = startTime;
		this.seatForShows = seatForShows;
		this.bookings = bookings;
	}

	public Show() {
		super();
	}

	@Override
	public String toString() {
		return "Show [id=" + id + ", movie=" + movie + ", screen=" + screen + ", startTime=" + startTime
				+ ", seatForShows=" + seatForShows + ", bookings=" + bookings + "]";
	}

	
	
	
}