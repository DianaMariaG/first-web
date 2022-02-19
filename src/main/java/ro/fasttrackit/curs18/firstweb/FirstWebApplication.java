package ro.fasttrackit.curs18.firstweb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstWebApplication.class, args);
	}
	@Bean
	CommandLineRunner atStartUp() {
		return args -> {
			System.out.println("Getting my car");
		};
	}
}
