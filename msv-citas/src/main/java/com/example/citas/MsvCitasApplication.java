package com.example.citas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.citas", "com.example.commons"})
public class MsvCitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvCitasApplication.class, args);
	}

}
