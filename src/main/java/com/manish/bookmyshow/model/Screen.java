package com.manish.bookmyshow.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
}
