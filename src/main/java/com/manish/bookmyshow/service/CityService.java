package com.manish.bookmyshow.service;

import org.springframework.stereotype.Service;

import com.manish.bookmyshow.model.City;

@Service
public interface CityService {
	
	public City createCity(City city);
	
	public City updateCity(Long id, City city);
	
	public City deleteCity(Long id);
	
	public City findCityByID(Long id);
	
	public City findCityByName(String name);

}
