package com.manish.bookmyshow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manish.bookmyshow.model.Screen;
import com.manish.bookmyshow.model.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long>{

	public Optional<Theatre> findByName(String name);
	
	@Query("SELECT t FROM Theatre t WHERE t.city.id = :cityId")
	List<Theatre> findTheatresByCityId(@Param("cityId") Long cityId);
}
