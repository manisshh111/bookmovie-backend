package com.manish.bookmyshow.DTO.AddShow;

public class CategPriceDTO {

	Long categoryId;
	int price;
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public CategPriceDTO(Long categoryId, int price) {
		super();
		this.categoryId = categoryId;
		this.price = price;
	}
	@Override
	public String toString() {
		return "CategPriceDTO [categoryId=" + categoryId + ", price=" + price + "]";
	}
	
	
	
}
