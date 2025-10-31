package com.idgs12.msb.msb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class MsbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsbApplication.class, args);
	}

}
