package com.manish.bookmyshow.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manish.bookmyshow.DTO.bookingDTO.PaymentPageDTO;
import com.manish.bookmyshow.DTO.bookingDTO.Ticket;
import com.manish.bookmyshow.model.Booking;
import com.manish.bookmyshow.model.Payment;
import com.manish.bookmyshow.model.Show;
import com.manish.bookmyshow.model.ShowSeat;
import com.manish.bookmyshow.repository.BookingRepository;
import com.manish.bookmyshow.repository.PaymentRepository;
import com.manish.bookmyshow.repository.ShowSeatRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingServiceImpl {

	@Autowired
	ShowSeatRepository showSeatRepository;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	BookingRepository bookingRepository;

	@Transactional
	public String lockSeats(List<Long> seatIds) {

		String sessionId = UUID.randomUUID().toString();

		List<ShowSeat> seats = showSeatRepository.findAllByIdWithLock(seatIds);

		boolean allSeatsCanBeLocked = seats.stream().noneMatch(seat -> seat.isLocked());

		if (allSeatsCanBeLocked) {
			seats.forEach(seat -> seat.lockSeat(sessionId));
			showSeatRepository.saveAll(seats);
			return sessionId;
		} else {
			return null;
		}
	}

	@Transactional
	public void processExpiredLocks() {
		LocalDateTime timeLimit = LocalDateTime.now().minusMinutes(5);
		List<ShowSeat> expiredSeats = showSeatRepository.findSeatsWithExpiredLock(timeLimit);

		for (ShowSeat seat : expiredSeats) {
			seat.setSessionId(null);
			seat.setLockTime(null);
			seat.setLocked(false);
			showSeatRepository.save(seat);
		}
	}

	@Transactional
	public Ticket bookSeats(PaymentPageDTO pdto) {
		//Get all seats by sessionId;
		List<ShowSeat> seats= showSeatRepository.findShowSeatsBySessionId(pdto.getSessionId());
		
		Show show = new Show();
		int i=0;
		for(ShowSeat s: seats) {
			show= s.getShow();
			i++;
			
			if(i>=1) {
				break;
			}
		}
		
		
		//set isBooked=true
		
		
		Payment payment = new Payment();
		payment.setCardNumber(pdto.getCardNumber());
		payment.setCardHolderName(pdto.getCardHolderName());
		payment.setExpiryMonth(pdto.getExpiryMonth());
		payment.setExpiryYear(pdto.getExpiryYear());
		payment.setCvv(pdto.getCvv());
		
		payment.setStatus(true);
		Payment p =paymentRepository.save(payment);
		
		//create a Booking object
		
		Booking booking = new Booking();
		booking.setEmail(pdto.getEmail());
		booking.setMobileNo(pdto.getMobile());
		booking.setPayment(p);
		booking.setShow(show);
		
		Booking b =bookingRepository.save(booking);
		
		seats.forEach(seat-> {
		seat.setBooked(true);
		seat.setBooking(b);
		});
		List<ShowSeat> s= showSeatRepository.saveAll(seats);
		
		Ticket t = new Ticket();
		t.setBookingId(b.getId());
		t.setMovieName(show.getMovie().getName());
		t.setTheatreName(show.getScreen().getTheatre().getName());
		t.setScreenName(show.getScreen().getName());
		t.setStartTime(show.getStartTime());
		t.setBookedSeats(s);
		
		return t;
		
	}

}
