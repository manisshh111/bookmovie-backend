package com.manish.bookmyshow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manish.bookmyshow.model.Movie;
import com.manish.bookmyshow.model.Theatre;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	public Optional<Movie> findByName(String name);

}
