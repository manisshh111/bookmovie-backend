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

}
