package com.manish.bookmyshow.DTO.bookingDTO;

public class SlCategoryDTO {

	Long categoryId;
	String categoryName;
	Integer price;
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public SlCategoryDTO(Long categoryId, String categoryName, Integer price) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.price = price;
	}
	public SlCategoryDTO() {
		super();
	}
	@Override
	public String toString() {
		return "SlCategoryDTO [categoryId=" + categoryId + ", categoryName=" + categoryName + ", price=" + price + "]";
	}
	
	
}
