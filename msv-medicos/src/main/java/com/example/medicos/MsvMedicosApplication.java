package com.example.medicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.medicos", "com.example.commons"})
public class MsvMedicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvMedicosApplication.class, args);
	}

}
