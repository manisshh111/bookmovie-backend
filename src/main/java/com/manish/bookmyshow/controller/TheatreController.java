package com.manish.bookmyshow.controller; 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manish.bookmyshow.DTO.ScreenDTO;
import com.manish.bookmyshow.DTO.SeatDTO;
import com.manish.bookmyshow.DTO.TheatreDTO;
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
@RequestMapping("/api/v1/theatre")
public class TheatreController {
	
	//CreateTheatre
	//updateTheatre
	//deleteTheatreById
	//getTheatreById
	//getTheatreByName
	//GetList<Screen>ByTheatreId;
	
	
	
	
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
	
	@PostMapping("/add")
	public ResponseEntity<?> createTheatre(@RequestBody TheatreDTO theatreDTO) {
		//create theatre
		//create screen
		//create seats
		Theatre t1 = new Theatre();
		t1.setName(theatreDTO.getTheatreName());
		Long cityId = Long.valueOf(theatreDTO.getCityId()).longValue();
		Optional<City> cityOpt = cityRepository.findById(cityId);

		if (!cityOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("City not found");
		}

		City city = cityOpt.get();
		t1.setCity(city);

		t1.setAddress(theatreDTO.getAddress());
		Theatre resTheatre =  theatreRepository.save(t1);
		
		List<Screen> screens = new ArrayList<Screen>();
		List<ScreenDTO> screensDto = theatreDTO.getScreens();
		for (ScreenDTO screenDto : screensDto) {
			Screen screen = new Screen();
			screen.setName(screenDto.getScreenName());
			screen.setTheatre(resTheatre);
			Screen screenRes= screenRepository.save(screen);
			List<Seat> seats = new ArrayList<Seat>();
			List<SeatDTO> seatsDto = screenDto.getSeats();
				
				for(SeatDTO seatDto: seatsDto) {
				
					for(char j = seatDto.getFromRow(); j<=seatDto.getToRow(); j++) {
						
						for(int i=seatDto.getFromSeat(); i<=seatDto.getToSeat(); i++) {
							
							String seatNumber = j+String.valueOf(i);

							Long categoryId = Long.valueOf(seatDto.getCategoryId()).longValue();
							Optional<Category> categoryOpt = categoryRepository.findById(categoryId);

							if (!categoryOpt.isPresent()) {
							    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Category not found");
							}

							Category category = categoryOpt.get();
							
							
							Seat s = new Seat();
							s.setCategory(category);
							s.setSeatNumber(seatNumber);
							s.setScreen(screenRes);
							seatRepository.save(s);

						}
					}
				}

		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(resTheatre);
		
	}
	
	@PutMapping("/update")
	public Theatre updateTheatre(@RequestBody TheatreDTO theatreDTO) {
		
		
		return null;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteTheatre(@PathVariable Long id) {
		
		try {
            theatreRepository.deleteById(id);
            return "Theatre with ID " + id + " was deleted successfully.";
        } catch (EmptyResultDataAccessException e) {
            return "Theatre with ID " + id + " does not exist.";
        }
		
	}
	
	
	@GetMapping("/get/{id}")
	public Theatre getTheatreById(@PathVariable Long id) {
		Optional<Theatre> theatre= theatreRepository.findById(id);
		
		if(theatre.isPresent()) {
			return theatre.get();
		}
		
		return null;
	}
	
	@GetMapping("/get/{theatreName}")
	public Theatre getTheatreByName(@PathVariable String theatreName) {
		Optional<Theatre> theatre= theatreRepository.findByName(theatreName);
		
		if(theatre.isPresent()) {
			return theatre.get();
		}
		
		return null;
	}
	
	@GetMapping("/theatres")
	public List<Theatre> getTheatres() {
		List<Theatre> theatres = theatreRepository.findAll();
		System.out.println("printing cities");
		for (Theatre theatre : theatres) {
		
            System.out.println(theatre.toString());
        }
		
		
		return theatres;
	}
	
	
	@GetMapping("/get/screens/{id}")
	public List<Screen> getScreensByTheatreId(@PathVariable Long id){

		Optional<Theatre> theatre = theatreRepository.findById(id);

		if (theatre.isPresent()) {
			return theatre.get().getScreens();
		}

		return null;
	}
	
	@GetMapping("/get/theatres/{cityId}")
	public List<Theatre> getTheatresByCity(@PathVariable Long cityId) {
		
		List<Theatre> theatres = theatreRepository.findTheatresByCityId(cityId);
		return theatres;
	}
	
}
