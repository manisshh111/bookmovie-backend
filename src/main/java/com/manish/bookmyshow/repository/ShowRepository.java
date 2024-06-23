package com.manish.bookmyshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manish.bookmyshow.model.Seat;
import com.manish.bookmyshow.model.Show;

public interface ShowRepository extends JpaRepository<Show, Long>{
	


}
