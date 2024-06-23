package com.manish.bookmyshow.controller;

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
import com.manish.bookmyshow.model.Movie;
import com.manish.bookmyshow.repository.MovieRepository;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
	
		//CreateMovie
		//updateMovie
		//getAllMovies
		//GetMovieByID
		//GetMovieByName
		//DeleteMovieByID
	
	@Autowired
	MovieRepository movieRepository;
	
	@PostMapping("/add")
	public Movie createMovie(@RequestBody Movie movie) {
		
		return movieRepository.save(movie);
		
	}
	
	@PutMapping("/update")
	public Movie updatemovie(@RequestBody Movie movie) {
		Long movieId= movie.getId();
		
		Optional<Movie> movieRes = movieRepository.findById(movieId);
		if(movieRes.isPresent()) {
			//update
			return movieRepository.save(movie);
		}
		else {
			//Response - movie doesn't exist
		}
		
		return null;
	}
	
	
	@GetMapping("/get/{movieId}")
	public Movie getmovieById(@PathVariable Long movieId) {
		Optional<Movie> movie= movieRepository.findById(movieId);
		
		if(movie.isPresent()) {
			return movie.get();
		}
		
		return null;
	}
	
	@GetMapping("/get/{movieName}")
	public Movie getmovieByName(@PathVariable String movieName) {
		Optional<Movie> movie= movieRepository.findByName(movieName);
		
		if(movie.isPresent()) {
			return movie.get();
		}
		
		return null;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable Long id) {
		
		try {
            movieRepository.deleteById(id);
            return "movie with ID " + id + " was deleted successfully.";
        } catch (EmptyResultDataAccessException e) {
            return "movie with ID " + id + " does not exist.";
        }
	}
	
	
	

}
