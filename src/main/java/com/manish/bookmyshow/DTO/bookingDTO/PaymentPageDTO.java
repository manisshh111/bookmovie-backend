package com.manish.bookmyshow.DTO.bookingDTO;



public class PaymentPageDTO {
	
	String sessionId;
	String email;
	String mobile;
	String cardNumber;
	String cardHolderName;
	String expiryMonth;
	String expiryYear;
	String cvv;
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
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
	public PaymentPageDTO(String sessionId, String email, String mobile, String cardNumber, String cardHolderName,
			String expiryMonth, String expiryYear, String cvv) {
		super();
		this.sessionId = sessionId;
		this.email = email;
		this.mobile = mobile;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.cvv = cvv;
	}
	public PaymentPageDTO() {
		super();
	}
	@Override
	public String toString() {
		return "PaymentPageDTO [sessionId=" + sessionId + ", email=" + email + ", mobile=" + mobile + ", cardNumber="
				+ cardNumber + ", cardHolderName=" + cardHolderName + ", expiryMonth=" + expiryMonth + ", expiryYear="
				+ expiryYear + ", cvv=" + cvv + "]";
	}
	
	
	
	

}
