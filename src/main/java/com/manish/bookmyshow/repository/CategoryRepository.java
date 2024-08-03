package com.manish.bookmyshow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manish.bookmyshow.model.Category;
import com.manish.bookmyshow.model.Theatre;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Optional<Category> findByCategoryName(String categoryName);
	
	
	@Query("SELECT DISTINCT s.category FROM Seat s WHERE s.screen.id = :screenId")
	List<Category> findCategoriesByScreenId(@Param("screenId") Long screenId);;
}
