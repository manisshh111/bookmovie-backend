package com.manish.bookmyshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manish.bookmyshow.model.Movie;
import com.manish.bookmyshow.model.Seat;
import com.manish.bookmyshow.model.Show;

public interface ShowRepository extends JpaRepository<Show, Long>{
	
	 @Query("SELECT DISTINCT s.movie FROM Show s " +
	           "JOIN s.screen sc " +
	           "JOIN sc.theatre t " +
	           "JOIN t.city c " +
	           "WHERE c.id = :cityId AND s.startTime > CURRENT_TIMESTAMP")
	    List<Movie> findMoviesByCityId(@Param("cityId") Long cityId);

	 @Query("SELECT s FROM Show s "+
			 "JOIN s.screen sc " +
		     "JOIN sc.theatre t " +
		     "JOIN t.city c " +
		     "WHERE c.id = :cityId AND s.movie.id = :movieId AND s.startTime > CURRENT_TIMESTAMP")
	 List<Show> findShowsByMovieIdAndCityId(@Param("movieId") Long movieId, @Param("cityId") Long cityId);
	 
	 

}
