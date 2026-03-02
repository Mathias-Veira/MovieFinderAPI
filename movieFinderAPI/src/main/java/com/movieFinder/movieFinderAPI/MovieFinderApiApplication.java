package com.movieFinder.movieFinderAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MovieFinderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieFinderApiApplication.class, args);
	}

}
