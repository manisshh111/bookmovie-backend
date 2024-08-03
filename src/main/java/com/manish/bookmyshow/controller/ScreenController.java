package com.manish.bookmyshow.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manish.bookmyshow.DTO.ScreenDTO;
import com.manish.bookmyshow.model.Category;
import com.manish.bookmyshow.model.City;
import com.manish.bookmyshow.model.Screen;
import com.manish.bookmyshow.model.Seat;
import com.manish.bookmyshow.model.Theatre;
import com.manish.bookmyshow.repository.CategoryRepository;
import com.manish.bookmyshow.repository.CityRepository;
import com.manish.bookmyshow.repository.ScreenRepository;
import com.manish.bookmyshow.repository.SeatRepository;
import com.manish.bookmyshow.repository.TheatreRepository;


@RestController
@RequestMapping("/api/v1/screen")
public class ScreenController {
	
	//CreateScreen
	
	//UpdatScreen
	
	//deleteScreenByID
	
	//GetScreenByID
	
	//GetList<Seat>ByScreenId;
	
	//DeleteScreenByID
	
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	ScreenRepository screenRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	SeatRepository seatRepository;
	
	
	//Get screen by theatre ID
	
	@GetMapping("/get/{theatreId}")
	public List<Screen> getScreensByTheatre(@PathVariable Long theatreId) {
		
		List<Screen> screens = screenRepository.findScreensByTheatreId(theatreId);
		return screens;
	}
	
	
	
	
//	@PostMapping("/add")
//	public Screen createScreen(@RequestBody ScreenDTO screenDTO) {
//		Screen screen = new Screen();
//		screen.setName(screenDTO.getName());
//		screen.setTheatre(theatreRepository.findById(screenDTO.getTheatreId()).get());
//		
//		List<Seat> seats = new ArrayList<Seat>();
//		Screen s = new  Screen();
//		Map<String, List<String>> categoryToSeatNumber = screenDTO.getCategoryToSeatNumber();
//		
//		for (Map.Entry<String, List<String>> entry : categoryToSeatNumber.entrySet()) {
//
//		    String categoryName = entry.getKey();
//		    Category category = new Category();
//		    category.setCategoryName(categoryName);
//		    Category c = categoryRepository.save(category);
//		     s=screenRepository.save(screen);
//		    
//		    List<String> seatList = entry.getValue();
//		    
//		    for(String seat: seatList) {
//		    	Seat seat1 = new Seat();
//		    	seat1.setSeatNumber(seat);
//		    	seat1.setCategory(category);
//		    	seat1.setScreen(s);
//		    	seatRepository.save(seat1);
//		    	seats.add(seat1);
//		    }
//		    
//		   
//		}
//		
//		 s.setSeats(seats);
//		  return s;
//		
//		
////		return null;
//		
//	}
//	
//
//	
	
	
	
}
