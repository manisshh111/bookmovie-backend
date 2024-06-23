package com.manish.bookmyshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manish.bookmyshow.model.Category;
import com.manish.bookmyshow.model.Seat;

public interface CategoryRepository extends JpaRepository<Category, Long> {


	
}
