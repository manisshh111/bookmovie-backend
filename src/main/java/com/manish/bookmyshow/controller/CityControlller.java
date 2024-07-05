package com.manish.bookmyshow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manish.bookmyshow.model.City;
import com.manish.bookmyshow.repository.CityRepository;
import com.manish.bookmyshow.service.CityService;

@RestController
@RequestMapping("/api/v1/city")

public class CityControlller {

	//CreateCity
	//updateCity
	//findByCityId
	//findByCityName
	//deleteById
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	CityService cityService;
	
	@PostMapping("/add")
	public City createCity(@RequestBody City city) {
		return cityService.createCity(city);
		
	}
	
	@PutMapping("/update")
	public City updateCity(@RequestBody City city) {
		Long cityId= city.getId();
		
		Optional<City> cityRes = cityRepository.findById(cityId);
		if(cityRes.isPresent()) {
			//update
			return cityRepository.save(city);
		}
		else {
			//Response - city doesn't exist
		}
		
		return null;
	}
	
	
	@GetMapping("/get/{cityId}")
	public City getCityById(@PathVariable Long cityId) {
		Optional<City> city= cityRepository.findById(cityId);
		
		if(city.isPresent()) {
			return city.get();
		}
		
		return null;
	}
	
	@GetMapping("/get/{cityName}")
	public City getCityByName(@PathVariable String cityName) {
		Optional<City> city= cityRepository.findByCityName(cityName);
		
		if(city.isPresent()) {
			return city.get();
		}
		
		return null;
	}
	@GetMapping("/cities")
	public List<City> getCities() {
		List<City> cities = cityRepository.findAll();
		System.out.println("printing cities");
		for (City city : cities) {
		
            System.out.println(city.toString());
        }
		
		
		return cities;
	}
	
	
	
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable Long id) {
		
		try {
            cityRepository.deleteById(id);
            return "City with ID " + id + " was deleted successfully.";
        } catch (EmptyResultDataAccessException e) {
            return "City with ID " + id + " does not exist.";
        }
	}
	
	
	
	
}
