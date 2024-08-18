package com.manish.bookmyshow.model;

import java.util.List;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Table(name = "bookings")
@Data
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "show_id")
	Show show;
	
	@JsonIgnore
	@OneToMany(mappedBy = "booking")
	List<ShowSeat> seats;
	
	@OneToOne
	@JoinColumn(name = "payment_id")
	Payment payment;
	
	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	@NotEmpty(message = "Email cannot be empty")
	private String email;
	
	
	 String mobileNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public List<ShowSeat> getSeats() {
		return seats;
	}

	public void setSeats(List<ShowSeat> seats) {
		this.seats = seats;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Booking(Long id, Show show, List<ShowSeat> seats, Payment payment,
			@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") @NotEmpty(message = "Email cannot be empty") String email,
			@Size(min = 0, max = 10) String mobileNo) {
		super();
		this.id = id;
		this.show = show;
		this.seats = seats;
		this.payment = payment;
		this.email = email;
		this.mobileNo = mobileNo;
	}

	public Booking() {
		super();
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", show=" + show + ", seats=" + seats + ", payment=" + payment + ", email=" + email
				+ ", mobileNo=" + mobileNo + "]";
	}
	 
	 
	 
	 

}
