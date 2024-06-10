package com.manish.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manish.bookmyshow.model.Category;

public interface CategoryRepository extends JpaRepository<Long, Category> {

	
}
