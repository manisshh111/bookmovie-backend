package com.manish.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manish.bookmyshow.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

}
