package com.manish.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manish.bookmyshow.model.Movie;

public interface MovieRepository extends JpaRepository<Long, Movie>{

}
