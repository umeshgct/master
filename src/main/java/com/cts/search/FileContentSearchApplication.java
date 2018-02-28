package com.cts.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = { "com.cts.search"})
public class FileContentSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileContentSearchApplication.class, args);
	}
}
