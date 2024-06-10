package com.manish.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manish.bookmyshow.model.Show;

public interface ShowRepository extends JpaRepository<Long, Show>{

}
