package com.manish.bookmyshow.controller; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.manish.bookmyshow.DTO.TheatreDTO;
import com.manish.bookmyshow.model.Screen;
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
	public Theatre createTheatre(@RequestBody TheatreDTO theatreDTO) {
		Theatre theatre = new Theatre();
		theatre.setName(theatreDTO.getName());
		theatre.setAddress(theatreDTO.getAddress());
		theatre.setCity((cityRepository.findById(theatreDTO.getCityId())).get());
		return theatreRepository.save(theatre);
		
	}
	
	@PutMapping("/update")
	public Theatre updateTheatre(@RequestBody TheatreDTO theatreDTO) {
		Theatre theatre = new Theatre();
		theatre.setId(theatreDTO.getId());
		theatre.setName(theatreDTO.getName());
		theatre.setAddress(theatreDTO.getAddress());
		theatre.setCity((cityRepository.findById(theatreDTO.getCityId())).get());
		
		
		Optional<Theatre> theatreRes = theatreRepository.findById(theatre.getId());
		if(theatreRes.isPresent()) {
			//update
			return theatreRepository.save(theatre);
		}
		else {
			//Response - city doesn't exist
		}
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
	
	
	@GetMapping("/get/screens/{id}")
	public List<Screen> getScreensByTheatreId(@PathVariable Long id){

		Optional<Theatre> theatre = theatreRepository.findById(id);

		if (theatre.isPresent()) {
			return theatre.get().getScreens();
		}

		return null;
	}
	
}
