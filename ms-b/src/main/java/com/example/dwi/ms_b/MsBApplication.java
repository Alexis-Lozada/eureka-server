package com.example.dwi.ms_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.dwi.ms_b.client")
public class MsBApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBApplication.class, args);
	}

}
