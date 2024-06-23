package com.manish.bookmyshow.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
@Table(name = "screens")
public class Screen {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	
	String name;
	
	@ManyToOne
	@JoinColumn(name = "theatre_id")
	Theatre theatre;
	
	
	@OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
	List<Seat> seats;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Screen(Long id, String name, Theatre theatre, List<Seat> seats) {
		super();
		this.id = id;
		this.name = name;
		this.theatre = theatre;
		this.seats = seats;
	}

	public Screen() {
		super();
	}

	@Override
	public String toString() {
		return "Screen [id=" + id + ", name=" + name + ", theatre=" + theatre + ", seats=" + seats + "]";
	}
	
	
	
}
