package com.matheusvsdev.picpay_challenge_resolution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class
PicpayChallengeResolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicpayChallengeResolutionApplication.class, args);
	}

}
