package com.example.SystemBDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SystemBDemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(SystemBDemoApplication.class, args);

		System.out.println("SystemBDemo Application Started");
	}
}
