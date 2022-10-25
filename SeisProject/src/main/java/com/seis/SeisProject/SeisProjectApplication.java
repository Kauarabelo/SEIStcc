package com.seis.SeisProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeisProjectApplication {

	public static void main(String[] args) {
            ClassLoader classLoader = SeisProjectApplication.class.getClassLoader();
            
            SpringApplication.run(SeisProjectApplication.class, args);
	}

}
