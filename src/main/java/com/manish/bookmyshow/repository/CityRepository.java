package com.manish.bookmyshow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manish.bookmyshow.model.City;

public interface CityRepository extends JpaRepository<City, Long>{
	
	public Optional<City> findByCityName(String cityName);

}
