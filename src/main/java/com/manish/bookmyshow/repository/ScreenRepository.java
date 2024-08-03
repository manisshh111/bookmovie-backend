package com.manish.bookmyshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manish.bookmyshow.model.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Long>{

	@Query("SELECT s FROM Screen s WHERE s.theatre.id = :theatreId")
	List<Screen> findScreensByTheatreId(@Param("theatreId") Long theatreId);
	
	
}
