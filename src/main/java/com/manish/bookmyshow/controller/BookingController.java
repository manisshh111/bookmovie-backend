package com.manish.bookmyshow.controller;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manish.bookmyshow.DTO.bookingDTO.BookingDTO;
import com.manish.bookmyshow.DTO.bookingDTO.SeatLayoutPageDTO;
import com.manish.bookmyshow.DTO.bookingDTO.SlCategoryDTO;
import com.manish.bookmyshow.DTO.bookingDTO.SlSeatDTO;
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
		bdto.setTheatreName(show.get().getScreen().getTheatre().getName());
		bdto.setCityName(show.get().getScreen().getTheatre().getCity().getCityName());
		List<ShowSeat> showsSeats = showSeatRepository.findByShowId(showId);
		bdto.setShowSeats(showsSeats);
		return bdto;
	}
	
	@GetMapping("/seatlayout/{showId}")
	public SeatLayoutPageDTO getSeatLayoutByShowId(@PathVariable Long showId){
		
		SeatLayoutPageDTO slpdto = new SeatLayoutPageDTO();
		Optional<Show> show = showRepository.findById(showId);
		slpdto.setShowId(showId);
		slpdto.setMovieName(show.get().getMovie().getName());
		slpdto.setScreenName(show.get().getScreen().getName());
		slpdto.setStartTime(show.get().getStartTime());
		slpdto.setTheatreName(show.get().getScreen().getTheatre().getName());
		slpdto.setCityName(show.get().getScreen().getTheatre().getCity().getCityName());
		
		List<ShowSeat> showsSeats = showSeatRepository.findByShowId(showId);
		
		Map<SlCategoryDTO, SlSeatDTO> categSeatMap = new HashMap<SlCategoryDTO, SlSeatDTO>();
		//get List<ShowSeat> with unique categoryID
		List<ShowSeat> showSeatsUniqueCat= getUniqueCategoryShowSeats(showsSeats);
		for(ShowSeat s: showSeatsUniqueCat) {
			SlCategoryDTO slcdto = new SlCategoryDTO();
			slcdto.setCategoryId(s.getCategory().getId());
			slcdto.setCategoryName(s.getCategory().getCategoryName());
			slcdto.setPrice(s.getPrice());
			
			SlSeatDTO slsdto = new SlSeatDTO();
			Map<Character, List<ShowSeat>> rowSeatsMap = new HashMap<Character, List<ShowSeat>>();
			//find unique rows
			List<Character> rows = getUniqueRows(showsSeats);
			for(Character row: rows) {
				List<ShowSeat> seats = getSeatsByRowAndCategory(showsSeats, row, s.getCategory().getId());
				seats.sort(Comparator.comparingInt(seat -> Integer.parseInt(seat.getSeatNumber().substring(1))));
				rowSeatsMap.put(row, seats);
			}
			
			rowSeatsMap.entrySet().removeIf(entry -> entry.getValue().isEmpty());
			slsdto.setRowVsSeatsList(rowSeatsMap);
			//iterate over rows
			  //find all showSeats where seat number starts with row
			  //add to map
			categSeatMap.put(slcdto, slsdto);
		}
		
		slpdto.setCategSeatMap(categSeatMap);
		//iterate over list
		//Create SlSeatDTO object
		  //find 
		 // Sort categSeatMap by SlCategoryDTO.price in descending order
	    LinkedHashMap<SlCategoryDTO, SlSeatDTO> sortedCategSeatMap = categSeatMap.entrySet().stream()
	        .sorted((entry1, entry2) -> entry2.getKey().getPrice().compareTo(entry1.getKey().getPrice()))
	        .collect(Collectors.toMap(
	            Map.Entry::getKey,
	            Map.Entry::getValue,
	            (e1, e2) -> e1,
	            LinkedHashMap::new
	        ));
	    
	    slpdto.setCategSeatMap(sortedCategSeatMap);
		return slpdto;
	}
	
	
	public List<ShowSeat> getUniqueCategoryShowSeats(List<ShowSeat> showSeats) {
	    Map<Long, ShowSeat> uniqueCategoryShowSeatsMap = showSeats.stream()
	        .collect(Collectors.toMap(
	            showSeat -> showSeat.getCategory().getId(), // keyMapper: category ID
	            showSeat -> showSeat,                      // valueMapper: showSeat object
	            (existing, replacement) -> existing        // mergeFunction: keep existing showSeat if category ID is duplicated
	        ));

	    return new ArrayList<>(uniqueCategoryShowSeatsMap.values());
	}
	
	public List<Character> getUniqueRows(List<ShowSeat> showSeats) {
	    // Use a stream to map each ShowSeat to the first character of its seatNumber and collect unique values into a set
	    Set<Character> uniqueRowsSet = showSeats.stream()
	        .map(showSeat -> showSeat.getSeatNumber().charAt(0))
	        .collect(Collectors.toSet());

	    // Convert the set to a list to maintain the return type as List<Character>
	    return new ArrayList<>(uniqueRowsSet);
	}
	
	public List<ShowSeat> getSeatsByRowAndCategory(List<ShowSeat> showSeats, char row, Long categoryId) {
	    // Use a stream to filter ShowSeat objects where the seatNumber starts with the specified row character and categoryId matches
	    return showSeats.stream()
	        .filter(showSeat -> showSeat.getSeatNumber().charAt(0) == row && showSeat.getCategory().getId().equals(categoryId))
	        .collect(Collectors.toList());
	}
	
	
	
	
	
}
