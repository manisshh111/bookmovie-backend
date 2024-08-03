package com.manish.bookmyshow.controller;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manish.bookmyshow.DTO.bookingDTO.BookingDTO;
import com.manish.bookmyshow.model.Show;
import com.manish.bookmyshow.model.ShowSeat;
import com.manish.bookmyshow.repository.CityRepository;
import com.manish.bookmyshow.repository.MovieRepository;
import com.manish.bookmyshow.repository.ScreenRepository;
import com.manish.bookmyshow.repository.SeatRepository;
import com.manish.bookmyshow.repository.ShowRepository;
import com.manish.bookmyshow.repository.ShowSeatRepository;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

	@Autowired
	ScreenRepository screenRepository;
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	SeatRepository seatRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	ShowSeatRepository showSeatRepository;
	
	
	
	@GetMapping("/seats/{showId}")
	public BookingDTO getSeatsByShowId(@PathVariable Long showId){
		BookingDTO bdto = new BookingDTO();
		Optional<Show> show = showRepository.findById(showId);
		bdto.setShowId(showId);
		bdto.setMovieName(show.get().getMovie().getName());
		bdto.setScreenName(show.get().getScreen().getName());
		bdto.setStartTime(show.get().getStartTime());
		List<ShowSeat> showsSeats = showSeatRepository.findByShowId(showId);
		bdto.setShowSeats(showsSeats);
		return bdto;
	}
	
	
	
	
	
	
	
	
	
}
