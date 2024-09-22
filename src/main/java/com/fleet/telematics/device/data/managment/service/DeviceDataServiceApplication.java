package com.fleet.telematics.device.data.managment.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.fleet"})
public class DeviceDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceDataServiceApplication.class, args);
	}

}
