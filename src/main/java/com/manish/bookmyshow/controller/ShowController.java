package com.manish.bookmyshow.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manish.bookmyshow.DTO.ShowDTO2;
import com.manish.bookmyshow.DTO.AddShow.CategPriceDTO;
import com.manish.bookmyshow.DTO.AddShow.CreateShowDTO;
import com.manish.bookmyshow.DTO.AddShow.ShowDTO;
import com.manish.bookmyshow.DTO.selectShowDTO.SelectShowDTO;
import com.manish.bookmyshow.DTO.selectShowDTO.ShowsListDTO;
import com.manish.bookmyshow.DTO.selectShowDTO.TheatresListDTO;
import com.manish.bookmyshow.model.City;
import com.manish.bookmyshow.model.Movie;
import com.manish.bookmyshow.model.Screen;
import com.manish.bookmyshow.model.Seat;
import com.manish.bookmyshow.model.Show;
import com.manish.bookmyshow.model.ShowSeat;
import com.manish.bookmyshow.repository.CategoryRepository;
import com.manish.bookmyshow.repository.CityRepository;
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
	CityRepository cityRepository;
	
	@Autowired
	ShowSeatRepository showSeatRepository;
	
//	@PostMapping("/add")
//	public Show createShow(@RequestBody ShowDTO2 showDto) {
//		
//		Show show = new Show();
//		show.setScreen(screenRepository.findById(showDto.getScreenId()).get());
//		show.setMovie(movieRepository.findById(showDto.getMovieId()).get());
//		show.setStartTime(showDto.getStartTime());
//		
//		Show s = showRepository.save(show);
//		
////		set showSeats - seatNumber, category, price
//		
//		//getAllSeatsByScreenId
//		//List<Seat> seats12= screenRepository.findById(showDto.getScreenId());
//		
//		List<ShowSeat> showSeats = new ArrayList<ShowSeat>();
//		
//		Map<Long, Integer> categoryIdToPrice = showDto.getCategoryIdToPrice();
//		
//		for (Map.Entry<Long, Integer> entry : categoryIdToPrice.entrySet()) {
//			
//			List<Seat> seatsByCategory = seatRepository.findByCategoryId(entry.getKey());
//			Integer price = entry.getValue();
//			
//			for(Seat s1: seatsByCategory) {
//				
//				ShowSeat showSeat = new ShowSeat();
//				showSeat.setCategory(s1.getCategory());
//				showSeat.setSeatNumber(s1.getSeatNumber());
//				showSeat.setPrice(entry.getValue());
//				showSeat.setShow(s);
//				ShowSeat s2 = showSeatRepository.save(showSeat);
//				showSeats.add(s2);
//			}
//		}
//		
//		s.setSeatForShows(showSeats);
//		
//		return s;
//		
//	}

	@PostMapping("/addShows")
	public List<Show> createShows(@RequestBody CreateShowDTO createShowDto) {

		List<ShowDTO> shows = createShowDto.getShows();
		List<Show> createdShows = new ArrayList<Show>();
		for (ShowDTO showDto : shows) {

			Show show = new Show();
			show.setScreen(screenRepository.findById(showDto.getScreenId()).get());
			show.setMovie(movieRepository.findById(showDto.getMovieId()).get());
			show.setStartTime(showDto.getStartTime());

			Show s = showRepository.save(show);
			
			List<ShowSeat> showSeats = new ArrayList<ShowSeat>();

			List<CategPriceDTO> categPrices = showDto.getCategPrice();

			for (CategPriceDTO categPrice : categPrices) {

				List<Seat> seatsByCategory = seatRepository.findByCategoryIdAndScreenId(categPrice.getCategoryId(), s.getScreen().getId());	
				Integer price = categPrice.getPrice();

				for (Seat s1 : seatsByCategory) {

					ShowSeat showSeat = new ShowSeat();
					showSeat.setCategory(s1.getCategory());
					showSeat.setSeatNumber(s1.getSeatNumber());
					showSeat.setPrice(price);
					showSeat.setShow(s);
					ShowSeat s2 = showSeatRepository.save(showSeat);
					showSeats.add(s2);
				}
			}

			//s.setSeatForShows(showSeats);
			createdShows.add(s);

		}

		return createdShows;
	}
	
	
	@GetMapping("/shows/{cityId}")
	public List<Movie> getMoviesByCityId(@PathVariable Long cityId) {
		List<Movie> movies = showRepository.findMoviesByCityId(cityId);
		return  movies;
		
	}
	
	
	@GetMapping("/shows")
	public List<Show> getShows() {
		List<Show> shows = showRepository.findAll();
		return shows;
		
	}
	
	@GetMapping("/shows/{cityId}/{movieId}")
	public SelectShowDTO getTheatresByCityAndMovie(@PathVariable Long cityId, @PathVariable Long movieId){
		
		List<Show> shows = showRepository.findShowsByMovieIdAndCityId(movieId, cityId);
		SelectShowDTO ssdto = new SelectShowDTO();
		Optional<Movie> movie = movieRepository.findById(movieId);
		Optional<City> city =cityRepository.findById(cityId);
		ssdto.setCityName(city.get().getCityName());
		ssdto.setMovieName(movie.get().getName());
		List<TheatresListDTO> tldto = new ArrayList<TheatresListDTO>();
		tldto= convertToTheatresListDTO(shows);
		ssdto.setTheatres(tldto);
		return ssdto;
	}
	
	public List<TheatresListDTO> convertToTheatresListDTO(List<Show> shows) {
	    Map<String, List<ShowsListDTO>> showsByTheatre = shows.stream()
	        .collect(Collectors.groupingBy(
	            show -> show.getScreen().getTheatre().getName(),
	            Collectors.mapping(
	                show -> new ShowsListDTO(show.getId(), show.getStartTime()),
	                Collectors.toList()
	            )
	        ));

	    return showsByTheatre.entrySet().stream()
	        .map(entry -> new TheatresListDTO(entry.getKey(), entry.getValue()))
	        .collect(Collectors.toList());
	}
	
	
	
}
