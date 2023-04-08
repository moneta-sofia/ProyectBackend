package com.dh.Clinica;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class 	ClinicaApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("src/main/log4J.properties");
		SpringApplication.run(ClinicaApplication.class, args);
	}

}
