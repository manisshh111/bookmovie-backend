package com.manish.bookmyshow.service;

import org.springframework.stereotype.Service;

import com.manish.bookmyshow.model.Theatre;

@Service
public interface TheatreService {

	public Theatre createTheatre(Theatre theatre);
	
	public Theatre updateTheatre(Long id, Theatre theatre);
	
	public Theatre deleteTheatre(Long id);
	
	public Theatre findTheatreByID(Long id);
	
	public Theatre findTheatreByName(String name);
}
