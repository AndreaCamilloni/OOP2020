package it.univpm.OOP2020.TwitterTrends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.univpm.OOP2020.TwitterTrends.dbConnection.TrendsDownload;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
