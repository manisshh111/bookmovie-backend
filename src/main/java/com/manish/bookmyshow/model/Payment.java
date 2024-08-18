package com.manish.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "payments")
@Data
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	boolean status;
	
	String cardNumber;
	
	String cardHolderName;
	
	String expiryMonth;
	
	String expiryYear;
	
	String cvv;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expityMonth) {
		this.expiryMonth = expityMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Payment(Long id, boolean status, String cardNumber, String cardHolderName, String expiryMonth,
			String expiryYear, String cvv) {
		super();
		this.id = id;
		this.status = status;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.cvv = cvv;
	}

	public Payment() {
		super();
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", status=" + status + ", cardNumber=" + cardNumber + ", cardHolderName="
				+ cardHolderName + ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + ", cvv=" + cvv + "]";
	}
	
	

}
