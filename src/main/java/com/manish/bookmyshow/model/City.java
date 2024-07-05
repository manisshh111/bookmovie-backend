package com.manish.bookmyshow.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cities")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(unique = true)
	String cityName;
	
	String state;
	
	String country;
	
	@JsonIgnore
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	List<Theatre> theatres;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Theatre> getTheatres() {
		return theatres;
	}

	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
	}

	public City(Long id, String cityName, String state, String country, List<Theatre> theatres) {
		super();
		this.id = id;
		this.cityName = cityName;
		this.state = state;
		this.country = country;
		this.theatres = theatres;
	}

	public City() {
		super();
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", cityName=" + cityName + ", state=" + state + ", country=" + country + ", theatres="
				+ theatres + "]";
	}

	
	
	
	
	
	
}
