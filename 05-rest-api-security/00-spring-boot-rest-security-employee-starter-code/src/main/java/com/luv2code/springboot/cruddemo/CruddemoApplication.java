package com.luv2code.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {
	// dependency e ekledigin anda security isini direkt olarak tum uygulamayi guvenli hale getiriyo ve konsolda sana bi password generate ediyor. Default username in de user zaten degistirmezsen.
	// degistirmek icin ise application.properies dosyasina bak
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

}
