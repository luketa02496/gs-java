package com.lucas.work_well;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class WorkWellApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkWellApplication.class, args);
	}

}
