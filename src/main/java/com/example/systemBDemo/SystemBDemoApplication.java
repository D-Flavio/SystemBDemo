package com.example.systemBDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SystemBDemoApplication {

	static void main(String[] args) {
		SpringApplication.run(SystemBDemoApplication.class, args);
	}
}
