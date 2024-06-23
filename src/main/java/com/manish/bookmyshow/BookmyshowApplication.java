package com.manish.bookmyshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BookmyshowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmyshowApplication.class, args);
	}

}
