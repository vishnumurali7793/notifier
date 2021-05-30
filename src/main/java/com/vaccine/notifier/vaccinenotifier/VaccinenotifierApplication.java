package com.vaccine.notifier.vaccinenotifier;

import com.google.gson.Gson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class VaccinenotifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinenotifierApplication.class, args);
	}

	// RestTemplate object
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	//Gson object
	@Bean
	public Gson getGson() {
		return new Gson();
	}

}
