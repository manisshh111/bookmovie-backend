package com.manish.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manish.bookmyshow.model.Theatre;
import com.manish.bookmyshow.repository.TheatreRepository;

@Service
public class TheatreServiceImpl implements TheatreService{

	@Autowired
	TheatreRepository theatreRepository;

	
	
	
	@Override
	public Theatre createTheatre(Theatre theatre) {
		
		Theatre t1 = theatre;
		
		return theatreRepository.save(t1);
		
	}

	@Override
	public Theatre updateTheatre(Long id, Theatre theatre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Theatre deleteTheatre(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Theatre findTheatreByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Theatre findTheatreByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
