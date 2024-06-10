package com.manish.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manish.bookmyshow.model.BookedSeat;

public interface BookedSeatRepository extends JpaRepository<Long, BookedSeat> {

}
