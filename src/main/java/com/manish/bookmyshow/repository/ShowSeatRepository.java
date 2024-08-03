package com.manish.bookmyshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manish.bookmyshow.model.ShowSeat;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long>{
	
	 @Query("SELECT ss FROM ShowSeat ss WHERE ss.show.id = :showId")
	    List<ShowSeat> findByShowId(@Param("showId") Long showId);
	 
//	 @Query("SELECT ss FROM ShowSeat ss WHERE ss.show.id = :showId")
//	 List<ShowSeat> findByShowId(@Param("showId") Long showId);

}
