package com.manish.bookmyshow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manish.bookmyshow.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Optional<Category> findByCategoryName(String categoryName);
	
}
