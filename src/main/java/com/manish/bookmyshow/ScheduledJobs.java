package com.manish.bookmyshow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.manish.bookmyshow.service.BookingServiceImpl;

@Component
public class ScheduledJobs {

	@Autowired
	BookingServiceImpl bookingService;
	
	@Scheduled(fixedRate = 60000)
    public void checkAndProcessExpiredLocks() {
        bookingService.processExpiredLocks();
        System.out.println("Locks released");
    }
}
