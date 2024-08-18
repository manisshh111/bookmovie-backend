package com.manish.bookmyshow.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manish.bookmyshow.model.ShowSeat;

import jakarta.persistence.LockModeType;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long>{
	
	 @Query("SELECT ss FROM ShowSeat ss WHERE ss.show.id = :showId")
	    List<ShowSeat> findByShowId(@Param("showId") Long showId);
	 
//	 @Query("SELECT ss FROM ShowSeat ss WHERE ss.show.id = :showId")
//	 List<ShowSeat> findByShowId(@Param("showId") Long showId);
	 
	 @Lock(LockModeType.PESSIMISTIC_WRITE)
	    @Query("SELECT s FROM ShowSeat s WHERE s.id IN :showSeatIds")
	    List<ShowSeat> findAllByIdWithLock(List<Long> showSeatIds);


	  @Query("SELECT ss FROM ShowSeat ss WHERE ss.isLocked = true AND ss.lockTime IS NOT NULL AND ss.lockTime < :timeLimit")
	  List<ShowSeat> findSeatsWithExpiredLock(LocalDateTime timeLimit);
	  
	  @Query("SELECT ss FROM ShowSeat ss WHERE ss.sessionId = :sessionId" )
	  List<ShowSeat> findShowSeatsBySessionId(String sessionId);
}
