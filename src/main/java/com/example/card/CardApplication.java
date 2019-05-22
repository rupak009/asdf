package com.example.card;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CardRepository repository) {
		return (args) -> {
			repository.save(new Card(50));
			repository.save(new Card(30));
			repository.save(new Card(1,20));
		};
	}




}
