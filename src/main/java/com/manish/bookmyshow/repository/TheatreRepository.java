package com.manish.bookmyshow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.manish.bookmyshow.model.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long>{

	public Optional<Theatre> findByName(String name);
}
