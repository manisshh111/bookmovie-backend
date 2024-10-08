package com.manish.bookmyshow.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "show_seats")
@Data
public class ShowSeat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	
	String seatNumber;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	Category category;
	
	@ManyToOne
	@JoinColumn(name = "show_id")
	@JsonIgnore
	Show show;
	 
	@ManyToOne
	@JoinColumn(name = "booking_id")
	Booking booking;
	
	int price;
	
	boolean isLocked = false;

	LocalDateTime lockTime;
	
	String sessionId;
	
	
	@Column(name = "is_booked")
	boolean isBooked;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	
	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean locked) {
		isLocked = locked;
	}

	public LocalDateTime getLockTime() {
		return lockTime;
	}

	public void setLockTime(LocalDateTime lockTime) {
		this.lockTime = lockTime;
	}

	

    public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public void lockSeat(String sessionId) {
        this.isLocked = true;
        this.lockTime = LocalDateTime.now();
        this.sessionId=sessionId;
    }


    public void unlockSeat() {
        this.isLocked = false;
        this.lockTime = null;
    }


    public boolean isLockExpired() {
        return isLocked && lockTime != null && lockTime.plusMinutes(5).isBefore(LocalDateTime.now());
    }


    public void checkAndReleaseLock() {
        if (isLockExpired()) {
            unlockSeat();
        }
    }

	public ShowSeat(Long id, String seatNumber, Category category, Show show, Booking booking, int price,
			boolean isLocked, LocalDateTime lockTime, boolean isBooked) {
		super();
		this.id = id;
		this.seatNumber = seatNumber;
		this.category = category;
		this.show = show;
		this.booking = booking;
		this.price = price;
		this.isLocked = isLocked;
		this.lockTime = lockTime;
		this.isBooked = isBooked;
	}

	public ShowSeat() {
		super();
	}

	@Override
	public String toString() {
		return "ShowSeat [id=" + id + ", seatNumber=" + seatNumber + ", category=" + category + ", show=" + show
				+ ", booking=" + booking + ", price=" + price + ", isLocked=" + isLocked + ", lockTime=" + lockTime
				+ ", isBooked=" + isBooked + "]";
	}
    
    
    

	
	
	
}
