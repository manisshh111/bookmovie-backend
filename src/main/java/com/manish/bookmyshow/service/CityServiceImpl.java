package com.manish.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manish.bookmyshow.model.City;
import com.manish.bookmyshow.repository.CityRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CityServiceImpl  implements CityService{

	@Autowired
	CityRepository cityRepository;
	
	
	
	@Override
	public City createCity(City city) {
		return cityRepository.save(city);
	}

	@Override
	public City updateCity(Long id, City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City deleteCity(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City findCityByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City findCityByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
