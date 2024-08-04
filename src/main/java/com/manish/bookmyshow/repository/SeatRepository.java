package com.manish.bookmyshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manish.bookmyshow.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{

	@Query("SELECT s FROM Seat s WHERE s.category.id = :categoryId AND s.screen.id = :screenId")
    List<Seat> findByCategoryIdAndScreenId(@Param("categoryId") Long categoryId, @Param("screenId") Long screenId);
	
	
}
