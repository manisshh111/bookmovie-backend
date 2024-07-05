package com.manish.bookmyshow.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manish.bookmyshow.DTO.ShowDTO;
import com.manish.bookmyshow.model.Screen;
import com.manish.bookmyshow.model.Seat;
import com.manish.bookmyshow.model.Show;
import com.manish.bookmyshow.model.ShowSeat;
import com.manish.bookmyshow.repository.CategoryRepository;
import com.manish.bookmyshow.repository.MovieRepository;
import com.manish.bookmyshow.repository.ScreenRepository;
import com.manish.bookmyshow.repository.SeatRepository;
import com.manish.bookmyshow.repository.ShowRepository;
import com.manish.bookmyshow.repository.ShowSeatRepository;

@RestController
@RequestMapping("/api/v1/show")
public class ShowController {

	@Autowired
	ScreenRepository screenRepository;
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	SeatRepository seatRepository;
	
	@Autowired
	ShowSeatRepository showSeatRepository;
	
	@PostMapping("/add")
	public Show createShow(@RequestBody ShowDTO showDto) {
		
		Show show = new Show();
		show.setScreen(screenRepository.findById(showDto.getScreenId()).get());
		show.setMovie(movieRepository.findById(showDto.getMovieId()).get());
		show.setStartTime(showDto.getStartTime());
		
		Show s = showRepository.save(show);
		
//		set showSeats - seatNumber, category, price
		
		//getAllSeatsByScreenId
		//List<Seat> seats12= screenRepository.findById(showDto.getScreenId());
		
		List<ShowSeat> showSeats = new ArrayList<ShowSeat>();
		
		Map<Long, Integer> categoryIdToPrice = showDto.getCategoryIdToPrice();
		
		for (Map.Entry<Long, Integer> entry : categoryIdToPrice.entrySet()) {
			
			List<Seat> seatsByCategory = seatRepository.findByCategoryId(entry.getKey());
			Integer price = entry.getValue();
			
			for(Seat s1: seatsByCategory) {
				
				ShowSeat showSeat = new ShowSeat();
				showSeat.setCategory(s1.getCategory());
				showSeat.setSeatNumber(s1.getSeatNumber());
				showSeat.setPrice(entry.getValue());
				showSeat.setShow(s);
				ShowSeat s2 = showSeatRepository.save(showSeat);
				showSeats.add(s2);
			}
		}
		
		s.setSeatForShows(showSeats);
		
		return s;
		
	}
	
}
