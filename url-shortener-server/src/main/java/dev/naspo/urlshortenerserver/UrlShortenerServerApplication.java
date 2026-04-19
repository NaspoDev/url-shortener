package dev.naspo.urlshortenerserver;

import dev.naspo.urlshortenerserver.utils.GlobalVariables;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrlShortenerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerServerApplication.class, args);

		if (System.getenv("RUN_ENV").equals(GlobalVariables.runEnvironmentProduction)) {
			System.out.println("Running in a production environment.");
		} else {
			System.out.println("Running in a development environment.");
		}
	}
}
