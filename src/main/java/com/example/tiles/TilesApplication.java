package com.example.tiles;

import jakarta.servlet.annotation.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TilesApplication.class, args);
	}

}
