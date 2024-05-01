package br.com.deimos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("br.com.deimos.repository")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
