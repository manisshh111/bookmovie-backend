package com.manish.bookmyshow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manish.bookmyshow.model.Category;
import com.manish.bookmyshow.repository.CategoryRepository;

@RestController
@RequestMapping("/api/v1/category")

public class CategoryControlller {

	//CreateCategory
	//updateCategory
	//findBycategoryId
	//findBycategoryName
	//deleteById
	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	@PostMapping("/add")
	public Category createCategory(@RequestBody Category category) {
		Category res= categoryRepository.save(category);
		return res;
				
		
		
	}
	
	@PutMapping("/update")
	public Category updatecategory(@RequestBody Category category) {
		Long categoryId= category.getId();
		
		Optional<Category> categoryRes = categoryRepository.findById(categoryId);
		if(categoryRes.isPresent()) {
			//update
			return categoryRepository.save(category);
		}
		else {
			//Response - category doesn't exist
		}
		
		return null;
	}
	
	
	@GetMapping("/get/{categoryId}")
	public Category getcategoryById(@PathVariable Long categoryId) {
		Optional<Category> category= categoryRepository.findById(categoryId);
		
		if(category.isPresent()) {
			return category.get();
		}
		
		return null;
	}
	
	@GetMapping("/get/{categoryName}")
	public Category getcategoryByName(@PathVariable String categoryName) {
		Optional<Category> category= categoryRepository.findByCategoryName(categoryName);
		
		if(category.isPresent()) {
			return category.get();
		}
		
		return null;
	}
	@GetMapping("/categories")
	public List<Category> getCategories() {
		List<Category> categories = categoryRepository.findAll();
		System.out.println("printing categories");
		for (Category category : categories) {
		
            System.out.println(category.toString());
        }
		
		
		return categories;
	}
	
	
	
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable Long id) {
		
		try {
            categoryRepository.deleteById(id);
            return "category with ID " + id + " was deleted successfully.";
        } catch (EmptyResultDataAccessException e) {
            return "category with ID " + id + " does not exist.";
        }
	}
	
	
	
	
}
