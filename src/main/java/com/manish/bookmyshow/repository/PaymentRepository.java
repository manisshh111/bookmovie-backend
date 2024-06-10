package com.manish.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manish.bookmyshow.model.Payment;

public interface PaymentRepository extends JpaRepository<Long, Payment>{

}
