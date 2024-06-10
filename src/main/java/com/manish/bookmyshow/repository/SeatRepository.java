package com.manish.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manish.bookmyshow.model.Seat;

public interface SeatRepository extends JpaRepository<Long, Seat>{

}
