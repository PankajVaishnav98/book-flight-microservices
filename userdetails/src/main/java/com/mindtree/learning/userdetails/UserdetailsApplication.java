package com.mindtree.learning.userdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableCaching
public class UserdetailsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UserdetailsApplication.class, args);
	}

}
